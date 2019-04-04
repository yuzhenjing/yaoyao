package com.ruoyi.project.system.prize.service;

import com.ruoyi.project.system.prize.domain.Prize;
import java.util.List;

/**
 * 奖惩列 服务层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface IPrizeService 
{
	/**
     * 查询奖惩列信息
     * 
     * @param prizeId 奖惩列ID
     * @return 奖惩列信息
     */
	public Prize selectPrizeById(Integer prizeId);
	
	/**
     * 查询奖惩列列表
     * 
     * @param prize 奖惩列信息
     * @return 奖惩列集合
     */
	public List<Prize> selectPrizeList(Prize prize);
	
	/**
     * 新增奖惩列
     * 
     * @param prize 奖惩列信息
     * @return 结果
     */
	public int insertPrize(Prize prize);
	
	/**
     * 修改奖惩列
     * 
     * @param prize 奖惩列信息
     * @return 结果
     */
	public int updatePrize(Prize prize);
		
	/**
     * 删除奖惩列信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePrizeByIds(String ids);
	
}
