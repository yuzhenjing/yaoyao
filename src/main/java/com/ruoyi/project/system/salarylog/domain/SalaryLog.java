package com.ruoyi.project.system.salarylog.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 薪资记录表 sys_salary_log
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
public class SalaryLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 薪资ID */
	private Long salaryId;
	/** 用户姓名 */
	private String userName;
	/** 用户ID */
	private Long userId;
	/** 薪资总额 */
	private BigDecimal grossSalary;
	/** 薪资备注 */
	private String salaryMsg;
	/** 录入人ID */
	private Long adminId;
	/** 管理员名称 */
	private String adminName;
	/** 添加时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(BigDecimal grossSalary) {
		this.grossSalary = grossSalary;
	}

	public String getSalaryMsg() {
		return salaryMsg;
	}

	public void setSalaryMsg(String salaryMsg) {
		this.salaryMsg = salaryMsg;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
