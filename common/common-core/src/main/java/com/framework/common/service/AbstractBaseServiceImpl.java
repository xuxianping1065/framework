package com.framework.common.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.framework.common.constant.BaseConstant;
import com.framework.common.constant.BaseErrorEnum;
import com.framework.common.dao.BaseDao;
import com.framework.common.exception.BusinessException;
import com.framework.common.model.BaseEntity;
import com.framework.common.model.OperatorEntity;
import com.framework.common.model.OperatorUser;
import com.framework.common.model.StateEntity;
import com.framework.common.query.Page;

/**
 * 基础服务的实现类
 * @version 1.0
 * @author xxp
 */
public abstract class AbstractBaseServiceImpl<E extends BaseEntity> implements BaseService<E> {

	
	/**
	 * 获得基础Dao
	 * @return
	 */
	public abstract BaseDao<E> getBaseDao();

	@Override
	public E save(E entity) throws BusinessException {
		getBaseDao().save(entity);
		return entity;
	}
	
	@Override
	public E save(E entity, OperatorUser operatorUser) throws BusinessException {
		if( entity instanceof OperatorEntity ){
			((OperatorEntity) entity).setCreaterId(operatorUser.getUserId());
			((OperatorEntity) entity).setCreaterIp(operatorUser.getUserIp());
			((OperatorEntity) entity).setCreateTime(new Date());
			((OperatorEntity) entity).setModifierId(operatorUser.getUserId());
			((OperatorEntity) entity).setModifierIp(operatorUser.getUserIp());
			((OperatorEntity) entity).setModifyTime(new Date());
		}
		if( entity instanceof StateEntity ){
			((StateEntity) entity).setState(BaseConstant.YNEnum.YES.getCode());
		}
		getBaseDao().save(entity);
		return entity;
	}

	@Override
	public E update(E entity) throws BusinessException {
		getBaseDao().update(entity);
		return entity;
	}

	@Override
	public E update(E entity, OperatorUser operatorUser) throws BusinessException {
		if( entity instanceof OperatorEntity ){
			((OperatorEntity) entity).setModifierId(operatorUser.getUserId());
			((OperatorEntity) entity).setModifierIp(operatorUser.getUserIp());
			((OperatorEntity) entity).setModifyTime(new Date());
		}
		getBaseDao().update(entity);
		return entity;
	}
	
	@Override
	public void delete(Integer id) throws BusinessException {
		if( id == null ){
			throw new BusinessException(BaseErrorEnum.E11_Para_Null.getCode(), "id为空");
		}
		getBaseDao().delete(id);
	}
	
	@Override
	public void delete(Integer id, OperatorUser operatorUser) throws BusinessException {
		if( id == null ){
			throw new BusinessException(BaseErrorEnum.E11_Para_Null.getCode(), "id为空");
		}
		getBaseDao().delete(id);
	}
	
	@Override
	public void delete(Integer[] ids) throws BusinessException {
		if( ids == null || ids.length == 0 ){
			throw new BusinessException(BaseErrorEnum.E11_Para_Null.getCode(), "ids为空");
		}
		getBaseDao().deleteBatch(ids);
	}

	@Override
	public E get(Integer id) throws BusinessException {
		if( id == null ){
			throw new BusinessException(BaseErrorEnum.E11_Para_Null.getCode(), "id为空");
		}
		return getBaseDao().get(id);
	}

	@Override
	public Page<E> queryForPage(Map<String, Object> paraMap) throws BusinessException {
		return getBaseDao().queryForPage(paraMap);
	}

	@Override
	public List<E> queryForList(Map<String, Object> paraMap) throws BusinessException {
		return getBaseDao().queryForList(paraMap);
	}

	@Override
	public int queryTotal(Map<String, Object> paraMap) throws BusinessException {
		return getBaseDao().queryTotal(paraMap);
	}
	
}
