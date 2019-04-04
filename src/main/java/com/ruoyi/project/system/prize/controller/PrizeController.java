package com.ruoyi.project.system.prize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.prize.domain.Prize;
import com.ruoyi.project.system.prize.service.IPrizeService;
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
 * 奖惩列 信息操作处理
 *
 * @author ruoyi
 * @date 2019-04-04
 */
@Controller
@RequestMapping("/system/prize")
public class PrizeController extends BaseController {
    private String prefix = "system/prize";

    @Autowired
    private IPrizeService prizeService;

    @RequiresPermissions("system:prize:view")
    @GetMapping()
    public String prize() {
        return prefix + "/prize";
    }

    /**
     * 查询奖惩列列表
     */
    @RequiresPermissions("system:prize:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Prize prize) {
        startPage();
        final User sysUser = ShiroUtils.getSysUser();
        if (!"yaoyao".equals(sysUser.getLoginName())) {
            prize.setUserId(sysUser.getUserId());
        }
        List<Prize> list = prizeService.selectPrizeList(prize);
        return getDataTable(list);
    }


    /**
     * 导出奖惩列列表
     */
    @RequiresPermissions("system:prize:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Prize prize) {
        List<Prize> list = prizeService.selectPrizeList(prize);
        ExcelUtil<Prize> util = new ExcelUtil<Prize>(Prize.class);
        return util.exportExcel(list, "prize");
    }

    @Autowired
    private IUserService userService;

    /**
     * 新增奖惩列
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("users", userService.selectUserList(new User()));
        return prefix + "/add";
    }

    /**
     * 新增保存奖惩列
     */
    @RequiresPermissions("system:prize:add")
    @Log(title = "奖惩列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Prize prize) {
        final User user = userService.selectUserById(prize.getUserId());
        prize.setUserName(user.getUserName());
        final User sysUser = ShiroUtils.getSysUser();
        prize.setAdminId(Integer.parseInt(String.valueOf(sysUser.getUserId())));
        prize.setAdminName(sysUser.getUserName());
        prize.setCreateTime(new Date());
        prize.setUpdateTime(new Date());
        return toAjax(prizeService.insertPrize(prize));
    }

    /**
     * 修改奖惩列
     */
    @GetMapping("/edit/{prizeId}")
    public String edit(@PathVariable("prizeId") Integer prizeId, ModelMap mmap) {
        Prize prize = prizeService.selectPrizeById(prizeId);
        mmap.put("prize", prize);
        return prefix + "/edit";
    }

    /**
     * 修改保存奖惩列
     */
    @RequiresPermissions("system:prize:edit")
    @Log(title = "奖惩列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Prize prize) {
        return toAjax(prizeService.updatePrize(prize));
    }

    /**
     * 删除奖惩列
     */
    @RequiresPermissions("system:prize:remove")
    @Log(title = "奖惩列", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(prizeService.deletePrizeByIds(ids));
    }

}
