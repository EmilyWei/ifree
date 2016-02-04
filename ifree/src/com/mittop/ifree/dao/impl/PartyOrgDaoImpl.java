package com.mittop.ifree.dao.impl;

import java.util.Date;

import javax.persistence.FlushModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.mittop.ifree.base.dao.BaseDaoImpl;
import com.mittop.ifree.common.Page;
import com.mittop.ifree.common.Pageable;
import com.mittop.ifree.dao.PartyOrgDao;
import com.mittop.ifree.model.PartyOrg;




@Repository("partyOrgDaoImpl")
public class PartyOrgDaoImpl extends BaseDaoImpl<PartyOrg, Long> implements PartyOrgDao {

	@Override
	public boolean partyOrgExists(String orgName) {
		if (StringUtils.isEmpty(orgName)) {
			return false;
		}
		String jpql = "select count(*) from PartyOrg partyOrg where lower(partyOrg.orgName) = lower(:orgName)";
		Long count = entityManager.createQuery(jpql, Long.class).setFlushMode(FlushModeType.COMMIT).setParameter("orgName", orgName).getSingleResult();
		return count > 0;
	}

	@Override
	public Page<PartyOrg> findPage(PartyOrg partyOrg, Date startDate, Date endDate, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PartyOrg> criteriaQuery = criteriaBuilder.createQuery(PartyOrg.class);
		Root<PartyOrg> root = criteriaQuery.from(PartyOrg.class);
		criteriaQuery.select(root);
		
		
		Predicate restrictions = criteriaBuilder.conjunction();
		
		if(StringUtils.isNotEmpty(partyOrg.getOrgName())){
			restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.like(root.<String> get("orgName"), "%" + partyOrg.getOrgName() + "%"));
		}
		if(StringUtils.isNotEmpty(partyOrg.getSecretary())){
			restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.like(root.<String> get("secretary"), "%" + partyOrg.getSecretary() + "%"));
		}
		if(StringUtils.isNotEmpty(partyOrg.getDeputySecretary())){
			restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.like(root.<String> get("deputySecretary"), "%" + partyOrg.getDeputySecretary() + "%"));
		}
		if(StringUtils.isNotEmpty(partyOrg.getCommitteeMember())){
			restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.like(root.<String> get("committeeMember"), "%" + partyOrg.getCommitteeMember() + "%"));
		}
		
		if (startDate != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.greaterThanOrEqualTo(root.<Date> get("changeDate"), startDate));
		}
		if (endDate != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.lessThanOrEqualTo(root.<Date> get("changeDate"), endDate));
		}
		criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createDate")));
		criteriaQuery.where(restrictions);
		return super.findPage(criteriaQuery, pageable);
	}


	
}
