package com.mittop.ifree.business.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mittop.ifree.IfreeException;
import com.mittop.ifree.base.controller.BaseController;
import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.business.model.inst.BusinessInst;
import com.mittop.ifree.business.model.inst.FormContext;
import com.mittop.ifree.business.service.BusinessInstService;

/**
 * 
*
 */
@Controller("businessFormController")
@RequestMapping("/business/form")
public class BusinessFormController extends BaseController {

	@Resource(name = "businessInstService")
	private BusinessInstService businessInstService;

	private BusinessHelper businessHelper = new BusinessHelper();

	/**
	 * 添加
	 * @throws IfreeException 
	 * 
	 * @RequestMapping(params="method=reg5")
    public String reg5(@RequestParam("name")String uname,
	 * 
	 */
	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String open(
			@RequestParam("businessName")String businessName,
			@RequestParam(value = "businessInstId", required=false)String businessInstId,
			@RequestParam(value = "formName", required=false) String formName,
			ModelMap model) throws IfreeException {

		FormContext formContext = buildFormContext(businessName);

		BusinessInst businessInst = businessInstService.getBusinessInst(formContext);

		model.addAttribute("form", businessHelper.getLayout(businessInst, formContext));

		model.addAttribute("businessName", formContext.getBusinessName());

		model.addAttribute("sysModel", businessHelper.getSysModel(businessInst,formContext));

		//model.addAttribute("form", businessHelper.getLayout(businessInst, formContext));

		String scriptlet = businessHelper.getFormScriptlet(businessInst, formContext);

		

		model.addAttribute("scriptlet", scriptlet);

		return "/business/form";
	}

	private FormContext buildFormContext(String businessName) {

		FormContext formContext = new FormContext();
		
		formContext.setBusinessName(businessName);
		
		return formContext;
	}

	String buildProperties(Business business) {

		return businessHelper.buildProperties(business);

	}


}
