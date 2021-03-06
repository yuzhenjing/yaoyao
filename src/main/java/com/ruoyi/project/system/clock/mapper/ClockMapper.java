package com.ruoyi.project.system.clock.mapper;

import com.ruoyi.project.system.clock.domain.Clock;

import java.util.List;

/**
 * 员工考勤 数据层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface ClockMapper 
{
	/**
     * 查询员工考勤信息
     * 
     * @param clockId 员工考勤ID
     * @return 员工考勤信息
     */
	public Clock selectClockById(Integer clockId);
	
	/**
     * 查询员工考勤列表
     * 
     * @param clock 员工考勤信息
     * @return 员工考勤集合
     */
	public List<Clock> selectClockList(Clock clock);
	
	/**
     * 新增员工考勤
     * 
     * @param clock 员工考勤信息
     * @return 结果
     */
	public int insertClock(Clock clock);
	
	/**
     * 修改员工考勤
     * 
     * @param clock 员工考勤信息
     * @return 结果
     */
	public int updateClock(Clock clock);
	
	/**
     * 删除员工考勤
     * 
     * @param clockId 员工考勤ID
     * @return 结果
     */
	public int deleteClockById(Integer clockId);
	
	/**
     * 批量删除员工考勤
     * 
     * @param clockIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteClockByIds(String[] clockIds);
	
}
