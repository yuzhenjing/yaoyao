package com.ruoyi.project.system.contract.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.contract.domain.Contract;
import com.ruoyi.project.system.contract.service.IContractService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 合同 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/system/contract")
public class ContractController extends BaseController
{
    private String prefix = "system/contract";
	
	@Autowired
	private IContractService contractService;
	
	@RequiresPermissions("system:contract:view")
	@GetMapping()
	public String contract()
	{
	    return prefix + "/contract";
	}
	
	/**
	 * 查询合同列表
	 */
	@RequiresPermissions("system:contract:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Contract contract)
	{
		startPage();
        List<Contract> list = contractService.selectContractList(contract);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出合同列表
	 */
	@RequiresPermissions("system:contract:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Contract contract)
    {
    	List<Contract> list = contractService.selectContractList(contract);
        ExcelUtil<Contract> util = new ExcelUtil<Contract>(Contract.class);
        return util.exportExcel(list, "contract");
    }
	
	/**
	 * 新增合同
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存合同
	 */
	@RequiresPermissions("system:contract:add")
	@Log(title = "合同", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Contract contract)
	{		
		return toAjax(contractService.insertContract(contract));
	}

	/**
	 * 修改合同
	 */
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
	{
		Contract contract = contractService.selectContractById(userId);
		mmap.put("contract", contract);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存合同
	 */
	@RequiresPermissions("system:contract:edit")
	@Log(title = "合同", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Contract contract)
	{		
		return toAjax(contractService.updateContract(contract));
	}
	
	/**
	 * 删除合同
	 */
	@RequiresPermissions("system:contract:remove")
	@Log(title = "合同", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(contractService.deleteContractByIds(ids));
	}
	
}
