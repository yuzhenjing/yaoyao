package com.ruoyi.project.system.salarylog.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.salarylog.domain.SalaryLog;
import com.ruoyi.project.system.salarylog.service.ISalaryLogService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 薪资记录 信息操作处理
 *
 * @author ruoyi
 * @date 2019-03-20
 */
@Controller
@RequestMapping("/system/salaryLog")
public class SalaryLogController extends BaseController {
    private String prefix = "system/salaryLog";

    @Autowired
    private ISalaryLogService salaryLogService;
    @Autowired
    private IUserService userService;


    @RequiresPermissions("system:salaryLog:view")
    @GetMapping()
    public String salaryLog() {
        return prefix + "/salaryLog";
    }

    /**
     * 查询薪资记录列表
     */
    @RequiresPermissions("system:salaryLog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SalaryLog salaryLog) {
        startPage();
        final User sysUser = ShiroUtils.getSysUser();
        if (!"yaoyao".equals(sysUser.getLoginName())) {
            salaryLog.setUserId(sysUser.getUserId());
        }
        List<SalaryLog> list = salaryLogService.selectSalaryLogList(salaryLog);
        return getDataTable(list);
    }


    /**
     * 导出薪资记录列表
     */
    @RequiresPermissions("system:salaryLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SalaryLog salaryLog) {
        List<SalaryLog> list = salaryLogService.selectSalaryLogList(salaryLog);
        ExcelUtil<SalaryLog> util = new ExcelUtil<SalaryLog>(SalaryLog.class);
        return util.exportExcel(list, "salaryLog");
    }

    /**
     * 新增薪资记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("users", userService.selectUserList(new User()));
        return prefix + "/add";
    }

    /**
     * 新增保存薪资记录
     */
    @RequiresPermissions("system:salaryLog:add")
    @Log(title = "薪资记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SalaryLog salaryLog) {
        salaryLog.setCreateTime(new Date());
        salaryLog.setUpdateTime(new Date());
        final User user = userService.selectUserById(salaryLog.getUserId());
        salaryLog.setUserName(user.getUserName());
        salaryLog.setAdminId(ShiroUtils.getSysUser().getUserId());
        salaryLog.setAdminName(ShiroUtils.getSysUser().getUserName());
        return toAjax(salaryLogService.insertSalaryLog(salaryLog));
    }

    /**
     * 修改薪资记录
     */
    @GetMapping("/edit/{salaryId}")
    public String edit(@PathVariable("salaryId") Integer salaryId, ModelMap mmap) {
        SalaryLog salaryLog = salaryLogService.selectSalaryLogById(salaryId);
        mmap.put("salaryLog", salaryLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存薪资记录
     */
    @RequiresPermissions("system:salaryLog:edit")
    @Log(title = "薪资记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SalaryLog salaryLog) {
        return toAjax(salaryLogService.updateSalaryLog(salaryLog));
    }

    /**
     * 删除薪资记录
     */
    @RequiresPermissions("system:salaryLog:remove")
    @Log(title = "薪资记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(salaryLogService.deleteSalaryLogByIds(ids));
    }

}
