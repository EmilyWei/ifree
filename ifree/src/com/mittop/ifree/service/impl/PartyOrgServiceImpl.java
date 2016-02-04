package com.mittop.ifree.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mittop.ifree.common.Page;
import com.mittop.ifree.common.Pageable;
import com.mittop.ifree.dao.PartyOrgDao;
import com.mittop.ifree.model.PartyOrg;
import com.mittop.ifree.service.PartyOrgService;



@Service("partyOrgServiceImpl")
public class PartyOrgServiceImpl extends BaseServiceImpl<PartyOrg, Long> implements PartyOrgService {

	@Resource(name = "partyOrgDaoImpl")
	private PartyOrgDao partyOrgDao;

	@Resource(name = "partyOrgDaoImpl")
	public void setBaseDao(PartyOrgDao partyOrgDao) {
		super.setBaseDao(partyOrgDao);
	}


	@Override
	public Page<PartyOrg> findPage(PartyOrg partyOrg, Date startDate, Date endDate, Pageable pageable) {
		return partyOrgDao.findPage(partyOrg, startDate, endDate, pageable);
	}


	@Override
	public boolean partyOrgExists(String orgName) {
		return partyOrgDao.partyOrgExists(orgName);
	}

}
