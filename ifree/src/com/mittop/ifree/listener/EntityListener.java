package com.mittop.ifree.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.mittop.ifree.model.BaseEntity;




/**
 * 
* @packageName: net.risesoft.core.listener
* @ClassName: EntityListener 
* @Description: Listener - 创建日期、修改日期处理
* @author songzewei
* @date 2015年9月10日 下午3:45:20 
*
 */
public class EntityListener {

	/**
	 * 保存前处理
	 * 
	 * @param entity
	 *            基类
	 */
	@PrePersist
	public void prePersist(BaseEntity entity) {
		entity.setCreateDate(new Date());
		entity.setModifyDate(new Date());
	}

	/**
	 * 更新前处理
	 * 
	 * @param entity
	 *            基类
	 */
	@PreUpdate
	public void preUpdate(BaseEntity entity) {
		entity.setModifyDate(new Date());
	}
}
