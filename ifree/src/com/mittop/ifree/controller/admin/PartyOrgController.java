package com.mittop.ifree.controller.admin;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mittop.ifree.common.Pageable;
import com.mittop.ifree.model.BaseEntity.Save;
import com.mittop.ifree.model.PartyOrg;
import com.mittop.ifree.service.PartyOrgService;



/**
 * 
* @packageName: net.risesoft.portal.controller.admin
* @ClassName: PartyOrgController 
* @Description: 党组织管理
* @author songzewei
* @date 2015年12月16日 下午4:48:37 
*
 */
@Controller("adminPartyOrgController")
@RequestMapping("/admin/party_org")
public class PartyOrgController extends BaseController {

	
	@Resource(name = "partyOrgServiceImpl")
	private PartyOrgService partyOrgService;
	

	/**
	 * 添加
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		return "/admin/party_org/add";
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(PartyOrg partyOrg, RedirectAttributes redirectAttributes) {
		if (!isValid(partyOrg, Save.class)) {
			return ERROR_VIEW;
		}
		partyOrgService.save(partyOrg);
		return "redirect:list.do";
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Long id, ModelMap model) {
		model.addAttribute("partyOrg", partyOrgService.find(id));
		return "/admin/party_org/edit";
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(PartyOrg partyOrg, RedirectAttributes redirectAttributes) {
		if (!isValid(partyOrg)) {
			return ERROR_VIEW;
		}
		partyOrgService.update(partyOrg, "orgName");
		return "redirect:list.do";
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(PartyOrg partyOrg,Date startDate, Date endDate,Pageable pageable, ModelMap model) {
		model.addAttribute("page", partyOrgService.findPage(partyOrg, startDate, endDate, pageable));
		model.addAttribute("partyOrg", partyOrg);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		return "/admin/party_org/list";
	}

	
	
}
