package com.ruoyi.project.system.clock.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 员工考勤表 sys_clock
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public class Clock extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 考勤编号 */
	private Integer clockId;
	/** 员工id */
	private Long userId;
	/** 员工姓名 */
	private String userName;
	/** 上班时间 */
	private Date beginTime;
	/** 下班时间 */
	private Date endTime;
	/** 考勤状态 */
	private String clockStatus;

	public void setClockId(Integer clockId) 
	{
		this.clockId = clockId;
	}

	public Integer getClockId() 
	{
		return clockId;
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
	public void setBeginTime(Date beginTime) 
	{
		this.beginTime = beginTime;
	}

	public Date getBeginTime() 
	{
		return beginTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setClockStatus(String clockStatus) 
	{
		this.clockStatus = clockStatus;
	}

	public String getClockStatus() 
	{
		return clockStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clockId", getClockId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .append("clockStatus", getClockStatus())
            .toString();
    }
}
