package com.ruoyi.project.system.salarylog.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.salarylog.mapper.SalaryLogMapper;
import com.ruoyi.project.system.salarylog.domain.SalaryLog;
import com.ruoyi.common.utils.text.Convert;

/**
 * 薪资记录 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
@Service
public class SalaryLogServiceImpl implements ISalaryLogService 
{
	@Autowired
	private SalaryLogMapper salaryLogMapper;

	/**
     * 查询薪资记录信息
     * 
     * @param salaryId 薪资记录ID
     * @return 薪资记录信息
     */
    @Override
	public SalaryLog selectSalaryLogById(Integer salaryId)
	{
	    return salaryLogMapper.selectSalaryLogById(salaryId);
	}
	
	/**
     * 查询薪资记录列表
     * 
     * @param salaryLog 薪资记录信息
     * @return 薪资记录集合
     */
	@Override
	public List<SalaryLog> selectSalaryLogList(SalaryLog salaryLog)
	{
	    return salaryLogMapper.selectSalaryLogList(salaryLog);
	}
	
    /**
     * 新增薪资记录
     * 
     * @param salaryLog 薪资记录信息
     * @return 结果
     */
	@Override
	public int insertSalaryLog(SalaryLog salaryLog)
	{
	    return salaryLogMapper.insertSalaryLog(salaryLog);
	}
	
	/**
     * 修改薪资记录
     * 
     * @param salaryLog 薪资记录信息
     * @return 结果
     */
	@Override
	public int updateSalaryLog(SalaryLog salaryLog)
	{
	    return salaryLogMapper.updateSalaryLog(salaryLog);
	}

	/**
     * 删除薪资记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSalaryLogByIds(String ids)
	{
		return salaryLogMapper.deleteSalaryLogByIds(Convert.toStrArray(ids));
	}
	
}
