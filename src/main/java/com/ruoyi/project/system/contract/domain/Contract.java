package com.ruoyi.project.system.contract.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同表 sys_contract
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public class Contract extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 合约人ID */
	private Long userId;
	/** 合同名称 */
	private String contractName;
	/** 合约时间 */
	private String contractPeriod;
	/** 主要薪资 */
	private BigDecimal majorSalary;
	/** 绩效薪资 */
	private BigDecimal awardSalary;
	/** 身份证照 */
	private String idcardUrl;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 合同编号 */
	private String contractNo;
	/** 管理员ID */
	private Integer adminId;

	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setContractName(String contractName) 
	{
		this.contractName = contractName;
	}

	public String getContractName() 
	{
		return contractName;
	}
	public void setContractPeriod(String contractPeriod) 
	{
		this.contractPeriod = contractPeriod;
	}

	public String getContractPeriod() 
	{
		return contractPeriod;
	}
	public void setMajorSalary(BigDecimal majorSalary) 
	{
		this.majorSalary = majorSalary;
	}

	public BigDecimal getMajorSalary() 
	{
		return majorSalary;
	}
	public void setAwardSalary(BigDecimal awardSalary) 
	{
		this.awardSalary = awardSalary;
	}

	public BigDecimal getAwardSalary() 
	{
		return awardSalary;
	}
	public void setIdcardUrl(String idcardUrl) 
	{
		this.idcardUrl = idcardUrl;
	}

	public String getIdcardUrl() 
	{
		return idcardUrl;
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
	public void setContractNo(String contractNo) 
	{
		this.contractNo = contractNo;
	}

	public String getContractNo() 
	{
		return contractNo;
	}
	public void setAdminId(Integer adminId) 
	{
		this.adminId = adminId;
	}

	public Integer getAdminId() 
	{
		return adminId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("contractName", getContractName())
            .append("contractPeriod", getContractPeriod())
            .append("majorSalary", getMajorSalary())
            .append("awardSalary", getAwardSalary())
            .append("idcardUrl", getIdcardUrl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("contractNo", getContractNo())
            .append("adminId", getAdminId())
            .toString();
    }
}
