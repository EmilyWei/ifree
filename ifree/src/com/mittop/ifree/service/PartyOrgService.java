package com.mittop.ifree.service;

import java.util.Date;

import com.mittop.ifree.common.Page;
import com.mittop.ifree.common.Pageable;
import com.mittop.ifree.model.PartyOrg;



/**
 * 
* @packageName: net.risesoft.portal.service
* @ClassName: PartyOrgService 
* @Description: 党组织Service层接口
* @author songzewei
* @date 2015年12月16日 下午4:35:56 
*
 */
public interface PartyOrgService extends BaseService<PartyOrg, Long> {

	/**
	 * 
	* @Title: partyOrgExists 
	* @Description: 判断党员组织是否存在
	* @param @param orgName 党组织名称
	* @param @return    
	* @return boolean 
	* @throws
	 */
	public boolean partyOrgExists(String orgName);
	
	
	/**
	 * 
	* @Title: findPage 
	* @Description: 根据查询条件查询党组信息
	* @param @param partyOrg党员组织
	* @param @param startDate 换届日期查询开始时间
	* @param @param endDate 换届日期查询结束时间
	* @param @param pageable
	* @param @return    
	* @return Page<PartyMember> 
	* @throws
	 */
	Page<PartyOrg> findPage(PartyOrg partyOrg,Date startDate, Date endDate,Pageable pageable);
	
}
