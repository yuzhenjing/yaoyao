package com.ruoyi.project.system.prize.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 奖惩列表 sys_prize
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public class Prize extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 奖励id */
	private Integer prizeId;
	/** 员工编号 */
	private Long userId;
	/** 员工姓名 */
	private String userName;
	/** 管理员id */
	private Integer adminId;
	/** 管理员名称 */
	private String adminName;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 奖励描述 */
	private String prizeDesc;

	public void setPrizeId(Integer prizeId) 
	{
		this.prizeId = prizeId;
	}

	public Integer getPrizeId() 
	{
		return prizeId;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setAdminId(Integer adminId) 
	{
		this.adminId = adminId;
	}

	public Integer getAdminId() 
	{
		return adminId;
	}
	public void setAdminName(String adminName) 
	{
		this.adminName = adminName;
	}

	public String getAdminName() 
	{
		return adminName;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setPrizeDesc(String prizeDesc) 
	{
		this.prizeDesc = prizeDesc;
	}

	public String getPrizeDesc() 
	{
		return prizeDesc;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("prizeId", getPrizeId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("adminId", getAdminId())
            .append("adminName", getAdminName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("prizeDesc", getPrizeDesc())
            .toString();
    }
}
