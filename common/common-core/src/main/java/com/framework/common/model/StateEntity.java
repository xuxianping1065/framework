package com.framework.common.model;

/**
 * 有状态实体需要实现的接口
 * @version 1.0
 * @author xxp
 */
public interface StateEntity extends BaseEntity {
	
	/**
	 * 获得 状态
	 * @return 状态
	 */
	public String getState();
	
	/**
	 * 设置 状态
	 * @param state 状态
	 */
	public void setState(String state);
	
}
