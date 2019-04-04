package com.ruoyi.project.system.contract.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.contract.mapper.ContractMapper;
import com.ruoyi.project.system.contract.domain.Contract;
import com.ruoyi.project.system.contract.service.IContractService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 合同 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Service
public class ContractServiceImpl implements IContractService 
{
	@Autowired
	private ContractMapper contractMapper;

	/**
     * 查询合同信息
     * 
     * @param userId 合同ID
     * @return 合同信息
     */
    @Override
	public Contract selectContractById(Long userId)
	{
	    return contractMapper.selectContractById(userId);
	}
	
	/**
     * 查询合同列表
     * 
     * @param contract 合同信息
     * @return 合同集合
     */
	@Override
	public List<Contract> selectContractList(Contract contract)
	{
	    return contractMapper.selectContractList(contract);
	}
	
    /**
     * 新增合同
     * 
     * @param contract 合同信息
     * @return 结果
     */
	@Override
	public int insertContract(Contract contract)
	{
	    return contractMapper.insertContract(contract);
	}
	
	/**
     * 修改合同
     * 
     * @param contract 合同信息
     * @return 结果
     */
	@Override
	public int updateContract(Contract contract)
	{
	    return contractMapper.updateContract(contract);
	}

	/**
     * 删除合同对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteContractByIds(String ids)
	{
		return contractMapper.deleteContractByIds(Convert.toStrArray(ids));
	}
	
}
