package com.ruoyi.project.system.salarylog.mapper;

import com.ruoyi.project.system.salarylog.domain.SalaryLog;
import java.util.List;	

/**
 * 薪资记录 数据层
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
public interface SalaryLogMapper 
{
	/**
     * 查询薪资记录信息
     * 
     * @param salaryId 薪资记录ID
     * @return 薪资记录信息
     */
	public SalaryLog selectSalaryLogById(Integer salaryId);
	
	/**
     * 查询薪资记录列表
     * 
     * @param salaryLog 薪资记录信息
     * @return 薪资记录集合
     */
	public List<SalaryLog> selectSalaryLogList(SalaryLog salaryLog);
	
	/**
     * 新增薪资记录
     * 
     * @param salaryLog 薪资记录信息
     * @return 结果
     */
	public int insertSalaryLog(SalaryLog salaryLog);
	
	/**
     * 修改薪资记录
     * 
     * @param salaryLog 薪资记录信息
     * @return 结果
     */
	public int updateSalaryLog(SalaryLog salaryLog);
	
	/**
     * 删除薪资记录
     * 
     * @param salaryId 薪资记录ID
     * @return 结果
     */
	public int deleteSalaryLogById(Integer salaryId);
	
	/**
     * 批量删除薪资记录
     * 
     * @param salaryIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSalaryLogByIds(String[] salaryIds);
	
}
