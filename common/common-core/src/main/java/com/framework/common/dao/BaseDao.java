package com.framework.common.dao;

import java.util.List;
import java.util.Map;

import com.framework.common.model.BaseEntity;
import com.framework.common.query.Page;

/**
 * 基础Dao
 * @version 1.0
 * @author xxp
 */
public interface BaseDao<E extends BaseEntity> {
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public int save(E entity);
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public int update(E entity);
	
	/**
	 * 删除
	 * @param id 
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * 批量删除
	 * @param ids 
	 * @return
	 */
	public int deleteBatch(Integer[] ids);
	
	/**
	 * 通过id查询实体
	 * @param id 
	 * @return
	 */
	public E get(Integer id);
	
	/**
	 * 按查询条件查询（分页）
	 * @param paraMap 查询条件
	 * @return 分页结果集
	 */
	public Page<E> queryForPage(Map<String, Object> paraMap);
	
	/**
	 * 按查询条件查询（不分页）
	 * @param paraMap 查询条件
	 * @return 结果集
	 */
	public List<E> queryForList(Map<String, Object> paraMap);
	
	/**
	 * 按查询条件查询记录总数
	 * @param paraMap 查询条件 
	 * @return 记录总数
	 */
	public int queryTotal(Map<String, Object> paraMap);
	
}
