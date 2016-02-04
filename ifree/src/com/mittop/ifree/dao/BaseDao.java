package com.mittop.ifree.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.LockModeType;

import com.mittop.ifree.common.Filter;
import com.mittop.ifree.common.Order;
import com.mittop.ifree.common.Page;
import com.mittop.ifree.common.Pageable;



/**
 * 
 * @packageName: net.risesoft.core.dao
 * @ClassName: BaseDao
 * @Description: Dao 基类
 * @author songzewei
 * @date 2015年9月10日 下午2:43:10
 * 
 * @param <T>
 * @param <ID>
 */
public interface BaseDao<T, ID extends Serializable> {

	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @return 实体对象，若不存在则返回null
	 */
	T find(ID id);

	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @param lockModeType
	 *            锁定方式
	 * @return 实体对象，若不存在则返回null
	 */
	T find(ID id, LockModeType lockModeType);

	/**
	 * 查找实体对象集合
	 * 
	 * @param first
	 *            起始记录
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 实体对象集合
	 */
	List<T> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	/**
	 * 查找实体对象分页
	 * 
	 * @param pageable
	 *            分页信息
	 * @return 实体对象分页
	 */
	Page<T> findPage(Pageable pageable);
	
	/**
	 * 查找实体对象分页
	 * 
	 * @param pageable
	 *            分页信息
	 * @return 实体对象分页
	 */
	Page<T> findPage(Object object,Pageable pageable);

	/**
	 * 查询实体对象数量
	 * 
	 * @param filters
	 *            筛选
	 * @return 实体对象数量
	 */
	long count(Filter... filters);

	/**
	 * 不需确定新建实体是否已经存在
	 * 
	 * @param entity
	 *            实体
	 * @return 实体对象
	 */
	T savePersist(T entity);

	/**
	 * 持久化实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void persist(T entity);

	/**
	 * 合并实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	T merge(T entity);

	/**
	 * 移除实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void remove(T entity);

	/**
	 * 刷新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void refresh(T entity);

	/**
	 * 刷新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @param lockModeType
	 *            锁定方式
	 */
	void refresh(T entity, LockModeType lockModeType);

	/**
	 * 获取实体对象ID
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象ID
	 */
	ID getIdentifier(T entity);

	/**
	 * 判断是否为托管状态
	 * 
	 * @param entity
	 *            实体对象
	 * @return 是否为托管状态
	 */
	boolean isManaged(T entity);

	/**
	 * 设置为游离状态
	 * 
	 * @param entity
	 *            实体对象
	 */
	void detach(T entity);

	/**
	 * 锁定实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @param lockModeType
	 *            锁定方式
	 */
	void lock(T entity, LockModeType lockModeType);

	/**
	 * 清除缓存
	 */
	void clear();

	/**
	 * 同步数据
	 */
	void flush();

	/**
	 * 
	* 根据Sql查询结果，返回List<Map>
	 */
	@Deprecated
	public List<Map<String, Object>> findListBySql(String sql);

	/**
	 * 
	* 根据Sql和Sql语句中的参数查询结果，返回List<Map>
	 */
	@Deprecated
	public List<Map<String, Object>> findListBySql(String sql, Object[] args);
	
	
	/**
	 * 
	* @Title: updateBySql 
	* @Description: 根据sql语句和参数更新数据
	* @param @param sql 更新sql语句
	* @param @param objects参数
	* @param @return 返回更新结果   
	* @return int 
	* @throws
	 */
	@Deprecated
	public int updateBySql(String sql, Object... objects);
	
	
	/**
	 * 
	* @Title: findPageListMap 
	* @Description: 根据sql语句，参数，分页实体查询分页数据
	* @param @param sql 语句
	* @param @param args 查询参数
	* @param @param page 分页对象
	* @param @return    Map<String,Object> ；list和recordTotal
	* @return Map<String,Object> 
	* @throws
	 */
	@Deprecated
	public Map<String,Object> findPageListMap(String sql,Object[] args,@SuppressWarnings("rawtypes") Page page);
	
	
	/**
	 * 
	* @Title: findPageListMap 
	* @Description: 根据sql语句，分页实体查询分页数据
	* @param @param sql语句
	* @param @param page分页对象
	* @param @return    Map<String,Object> ；list和recordTotal
	* @return Map<String,Object> 
	* @throws
	 */
	@Deprecated
	public Map<String,Object> findPageListMap(String sql,@SuppressWarnings("rawtypes") Page page);
	/**
	 * 
	* @Title: executeBySql 
	* @Description: 执行sql语句
	* @param @param sql语句
	* @throws
	 */
	@Deprecated
	public void executeBySql(String sql);
	
	
	@Deprecated
	public Map<String,Object> findMapBySql(String sql);
	
	@Deprecated
	public Page findPageSQL(String sql,Pageable pageable);
}
