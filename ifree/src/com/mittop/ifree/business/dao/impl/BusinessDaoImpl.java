package com.mittop.ifree.business.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.FlushModeType;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Repository;

import com.mittop.ifree.base.dao.BaseDaoImpl;
import com.mittop.ifree.business.dao.BusinessDao;
import com.mittop.ifree.business.model.def.Attribute;
import com.mittop.ifree.business.model.def.Business;

@Repository("businessDao")
public class BusinessDaoImpl extends BaseDaoImpl<Business, Long> implements BusinessDao {

	@Override
	public Business makeBusiness(String tableName) {
		Business business = new Business();
		String sql = "select * from " + tableName;
		SqlRowSet sqlRowSet = this.getJdbcTemplate().queryForRowSet(sql);
		SqlRowSetMetaData sqlRsmd = sqlRowSet.getMetaData();
		int columnCount = sqlRsmd.getColumnCount();
		for (int i = 0; i < columnCount; i++) {
			Attribute attribute = new Attribute();
			attribute.setOrder(i);
			attribute.setName(sqlRsmd.getColumnName(i));
			attribute.setCnName(sqlRsmd.getColumnName(i));
			attribute.setType(sqlRsmd.getColumnType(i));
			business.addAttribute(attribute);
		}

		business.setSqlList(sql);
		business.setSqlEdit(sql + " where 1=1");

		return business;
	}

	@Override
	public Business get(String businessId) {
		Business business = null;
//		Business business = super.find(businessId);
//		String def = this.read("D:/project/ifree/test/data/java/"+business.getName());
//		business.setDef(def);
		return business;
	}

	private String read(String name) {
		String xml = null;
		
		try {
			InputStream inputStream = new java.io.FileInputStream(name+".xml");
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			xml = new String(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}

	@Override
	public void save(Business business) {
		super.savePersist(business);
	}

	private void saveDef() {
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeSchema(Business business) {

		StringBuffer sb = new StringBuffer("");
		sb.append("CREATE TABLE `" + business.getTableName() + "` (");
		sb.append(" `id` int(11) NOT NULL AUTO_INCREMENT,");
		List<Attribute> attributes = business.getAttributes();

		for (int i = 0; i < attributes.size(); i++) {
			sb.append("`" + attributes.get(i).getName() + "` varchar(255) DEFAULT '',");
		}
		sb.append(" `tableName` varchar(255) DEFAULT '',");
		sb.append(" PRIMARY KEY (`id`)");
		sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		try {
			this.getJdbcTemplate().update(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Business getBusinessByName(String businessName) {

		Business business = null;

		String jpql = "from Business business where lower(business.name) = lower(:businessName)";

		List lst = super.entityManager.createQuery(jpql, Business.class).setFlushMode(FlushModeType.COMMIT)
				.setParameter("businessName", businessName).getResultList();
		
		if(lst.size()>0){
			business = (Business)lst.get(0);
			String def = this.read("D:/project/ifree/test/data/java/"+business.getName());
			business.setDef(def);
		}

		return business;
	}

}
