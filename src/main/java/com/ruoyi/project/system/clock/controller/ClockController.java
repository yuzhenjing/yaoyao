package com.ruoyi.project.system.clock.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.clock.domain.Clock;
import com.ruoyi.project.system.clock.service.IClockService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 员工考勤 信息操作处理
 *
 * @author ruoyi
 * @date 2019-04-03
 */
@Controller
@RequestMapping("/system/clock")
public class ClockController extends BaseController {
    private String prefix = "system/clock";

    @Autowired
    private IClockService clockService;

    @RequiresPermissions("system:clock:view")
    @GetMapping()
    public String clock() {
        return prefix + "/clock";
    }

    /**
     * 查询员工考勤列表
     */
    @RequiresPermissions("system:clock:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Clock clock) {
        startPage();
        final User sysUser = ShiroUtils.getSysUser();
        if (!User.isAdmin(sysUser.getUserId())) {
            clock.setUserId(sysUser.getUserId());
        }
        List<Clock> list = clockService.selectClockList(clock);
        return getDataTable(list);
    }


    /**
     * 导出员工考勤列表
     */
    @RequiresPermissions("system:clock:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Clock clock) {
        List<Clock> list = clockService.selectClockList(clock);
        ExcelUtil<Clock> util = new ExcelUtil<Clock>(Clock.class);
        return util.exportExcel(list, "clock");
    }

    /**
     * 新增员工考勤
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存员工考勤
     */
    @RequiresPermissions("system:clock:add")
    @Log(title = "员工考勤", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Clock clock) {
        clock = new Clock();
        final User sysUser = ShiroUtils.getSysUser();
        clock.setUserId(sysUser.getUserId());
        clock.setUserName(sysUser.getUserName());
        //根据当前时间进行判断  如果当前时间小于12点则是打卡 否则则是下班
        String sysTime = DateUtils.parseDateToStr("YYYYMMDD", new Date()) + "120000";
        String beginTime = DateUtils.parseDateToStr("YYYYMMDD", new Date()) + "090000";
        String endTime = DateUtils.parseDateToStr("YYYYMMDD", new Date()) + "180000";
        String currTime = DateUtils.parseDateToStr(DateUtils.YYYYMMDDHHMMSS, new Date());

        if (currTime.compareTo(beginTime) > 0 && currTime.compareTo(sysTime) < 0) {
            clock.setClockStatus("迟到");
        } else if (currTime.compareTo(endTime) < 0 && currTime.compareTo(sysTime) > 0) {
            clock.setClockStatus("早退");
        } else {
            clock.setClockStatus("正常");
        }
        if (currTime.compareTo(sysTime) < 0) {
            clock.setBeginTime(new Date());
        } else {
            clock.setEndTime(new Date());
        }
        final List<Clock> clocks = clockService.selectClockList(clock);
        if (CollectionUtils.isEmpty(clocks)) {
            return toAjax(clockService.insertClock(clock));
        }
        clock.setClockId(clocks.get(0).getClockId());
        return toAjax(clockService.updateClock(clock));
    }

    /**
     * 修改员工考勤
     */
    @GetMapping("/edit/{clockId}")
    public String edit(ModelMap mmap) {
        final User sysUser = ShiroUtils.getSysUser();

        Clock clock = new Clock();
        clock.setUserId(sysUser.getUserId());
        clock.setUserName(sysUser.getUserName());
        mmap.put("clock", clock);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工考勤
     */
    @RequiresPermissions("system:clock:edit")
    @Log(title = "员工考勤", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Clock clock) {
        //根据当前时间进行判断  如果当前时间小于12点则是打卡 否则则是下班
        String sysTime = DateUtils.parseDateToStr("YYYYMMDD", new Date()) + "120000";
        String currTime = DateUtils.parseDateToStr(DateUtils.YYYYMMDDHHMMSS, new Date());
        if (currTime.compareTo(sysTime) < 0) {
            clock.setBeginTime(new Date());
        } else {
            clock.setEndTime(new Date());
        }
        return toAjax(clockService.insertClock(clock));
    }

    /**
     * 删除员工考勤
     */
    @RequiresPermissions("system:clock:remove")
    @Log(title = "员工考勤", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(clockService.deleteClockByIds(ids));
    }

}
