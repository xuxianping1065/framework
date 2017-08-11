package com.framework.common.model;

import java.util.Date;

/**
 * 有操作者的实体需要实现的接口（包括创建人、创建时间、修改人、修改时间、最近更改时间的时间戳）
 * @version 1.0
 * @author xxp
 */
public interface OperatorEntity extends BaseEntity {


	/**
	 * 获取创建人id
	 * @return 创建人id
	 */
	public Integer getCreaterId();

	/**
	 * 设置创建人id
	 * @param createrId 创建人id
	 */
	public void setCreaterId(Integer createrId);
	
	/**
	 * 获取创建时间
	 * @return 创建时间
	 */
	public Date getCreateTime();
	
	/**
	 * 设置创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime);

	/**
	 * 获取修改人id
	 * @return 修改时间
	 */
	public Integer getModifierId();

	/**
	 * 设置修改人id
	 * @param modifierId 修改人id
	 */
	public void setModifierId(Integer modifierId);

	/**
	 * 获取修改时间
	 * @return 修改时间
	 */
	public Date getModifyTime();

	/**
	 * 设置修改时间
	 * @param modifyTime 修改时间
	 */
	public void setModifyTime(Date modifyTime);
	
	/**
	 * 获取创建人IP
	 * @return 创建人IP
	 */
	public String getCreaterIp();
	
	/**
	 * 设置创建人IP
	 * @param createrIp 创建人IP
	 */
	public void setCreaterIp(String createrIp);
	
	/**
	 * 获取修改人IP
	 * @return 修改人IP
	 */
	public String getModifierIp();
	
	/**
	 * 设置修改人IP
	 * @param modifierIp 修改人IP
	 */
	public void setModifierIp(String modifierIp);

	/**
	 * 获取最近更新时间
	 * @return 最近更新时间
	 */
	public Date getFlag();

	/**
	 * 设置最近更新时间
	 * @param flag 最近更新时间
	 */
	public void setFlag(Date flag);
	
}
