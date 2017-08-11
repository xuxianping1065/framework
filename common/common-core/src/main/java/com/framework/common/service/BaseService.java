package com.framework.common.service;

import java.util.List;
import java.util.Map;

import com.framework.common.exception.BusinessException;
import com.framework.common.model.BaseEntity;
import com.framework.common.model.OperatorUser;
import com.framework.common.query.Page;


/**
 * 基础service接口
 * @version 1.0
 * @author xxp
 */
public interface BaseService<E extends BaseEntity> {

	/**
	 * 保存
	 * @param entity
	 * @return 保存后的实体
	 */
	public E save(E entity) throws BusinessException;
	
	/**
	 * 保存
	 * @param entity
	 * @param operatorUser 操作人信息
	 * @return 保存后的实体
	 */
	public E save(E entity, OperatorUser operatorUser) throws BusinessException;
	
	/**
	 * 更新
	 * @param entity
	 * @return 更新后的实体
	 */
	public E update(E entity) throws BusinessException;
	
	/**
	 * 更新
	 * @param entity
	 * @param operatorUser 操作人信息
	 * @return 更新后的实体
	 */
	public E update(E entity, OperatorUser operatorUser) throws BusinessException;
	
	/**
	 * 删除
	 * @param id 
	 */
	public void delete(Integer id) throws BusinessException;
	
	/**
	 * 删除
	 * @param id 
	 * @param operatorUser 操作人信息
	 */
	public void delete(Integer id, OperatorUser operatorUser) throws BusinessException;
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids) throws BusinessException;
	
	/**
	 * 通过id查询实体
	 * @param id 
	 * @return
	 */
	public E get(Integer id) throws BusinessException;
	
	/**
	 * 按查询条件查询（分页）
	 * @param paraMap 查询条件
	 * @return 分页结果集
	 */
	public Page<E> queryForPage(Map<String, Object> paraMap) throws BusinessException;
	
	/**
	 * 按查询条件查询（不分页）
	 * @param paraMap 查询条件
	 * @return 结果集
	 */
	public List<E> queryForList(Map<String, Object> paraMap) throws BusinessException;
	
	
	/**
	 * 按查询条件查询记录总数
	 * @param paraMap 查询条件 
	 * @return 记录总数
	 */
	public int queryTotal(Map<String, Object> paraMap) throws BusinessException;
}
