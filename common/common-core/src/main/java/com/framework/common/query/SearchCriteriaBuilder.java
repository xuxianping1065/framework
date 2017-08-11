package com.framework.common.query;

import java.util.HashMap;
import java.util.Map;

/**
 * 条件构造工具类
 * @version 1.0
 * @author xxp
 */
public class SearchCriteriaBuilder {

	private Map<String, Object> criteriaMap = new HashMap<String, Object>();
	
	/**
	 * 新增查询条件
	 * @param name 属性名称
	 * @param value 属性值
	 * @return
	 */
	public SearchCriteriaBuilder addCriteria(String name, Object value){
		this.criteriaMap.put(name, value);
		
		return this; 
	}
	
	
	/**
	 * 新增查询条件
	 * @param name 属性名称
	 * @param value 属性值
	 * @return
	 */
	public Map<String, Object> build(){
		
		return criteriaMap;
	}
}
