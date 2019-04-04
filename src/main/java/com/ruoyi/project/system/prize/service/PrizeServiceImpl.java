package com.ruoyi.project.system.prize.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.prize.mapper.PrizeMapper;
import com.ruoyi.project.system.prize.domain.Prize;
import com.ruoyi.project.system.prize.service.IPrizeService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 奖惩列 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@Service
public class PrizeServiceImpl implements IPrizeService 
{
	@Autowired
	private PrizeMapper prizeMapper;

	/**
     * 查询奖惩列信息
     * 
     * @param prizeId 奖惩列ID
     * @return 奖惩列信息
     */
    @Override
	public Prize selectPrizeById(Integer prizeId)
	{
	    return prizeMapper.selectPrizeById(prizeId);
	}
	
	/**
     * 查询奖惩列列表
     * 
     * @param prize 奖惩列信息
     * @return 奖惩列集合
     */
	@Override
	public List<Prize> selectPrizeList(Prize prize)
	{
	    return prizeMapper.selectPrizeList(prize);
	}
	
    /**
     * 新增奖惩列
     * 
     * @param prize 奖惩列信息
     * @return 结果
     */
	@Override
	public int insertPrize(Prize prize)
	{
	    return prizeMapper.insertPrize(prize);
	}
	
	/**
     * 修改奖惩列
     * 
     * @param prize 奖惩列信息
     * @return 结果
     */
	@Override
	public int updatePrize(Prize prize)
	{
	    return prizeMapper.updatePrize(prize);
	}

	/**
     * 删除奖惩列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePrizeByIds(String ids)
	{
		return prizeMapper.deletePrizeByIds(Convert.toStrArray(ids));
	}
	
}
