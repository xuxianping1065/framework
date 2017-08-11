package com.framework.common.query;

import java.util.HashMap;

/**
 * 查询条件封装类
 * @version 1.0
 * @author xxp
 */
public class SearchCriteria extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;

	
	/**
	 * 新增查询条件
	 * @param name 属性名称
	 * @param value 属性值
	 * @return
	 */
	public SearchCriteria addCriteria(String name, Object value){
		this.put(name, value);
		
		return this; 
	}
}
