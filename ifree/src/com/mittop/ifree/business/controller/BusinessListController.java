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
import com.mittop.ifree.business.service.BusinessInstService;



/**
 * 
*
 */
@Controller("businessListController")
@RequestMapping("/business/list")
public class BusinessListController extends BaseController {

	
	@Resource(name = "businessInstService")
	private BusinessInstService businessInstService;
	

	private BusinessHelper businessHelper = new BusinessHelper ();
	
	/**
	 * 添加
	 * @throws IfreeException 
	 */
	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String open(
			@RequestParam("businessName")String businessName,
			@RequestParam(value = "businessInstId", required=false)String businessInstId,
			@RequestParam(value = "listName", required=false) String listName,
			ModelMap model) throws IfreeException {
		
		
		
		Business business = this.businessInstService.getBusiness(businessName);
		
		model.addAttribute("properties", buildProperties(business));
		
		return "/business/list";
	}

	String buildProperties(Business business){
		
		return businessHelper.buildProperties(business);
		
	}
	
}
