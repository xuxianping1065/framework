package com.framework.common.web.http;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.common.constant.BaseErrorEnum;
import com.framework.common.exception.BusinessException;
import com.framework.common.web.resp.BaseResponse;

/**
 * 
 * @version 1.0
 * @author xxp
 */
public abstract class ServiceTemplate {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private Map<String, Object> data = new HashMap<String, Object>();;
	
	public ServiceTemplate() {
		
	}
	
	public BaseResponse service(){
		BaseResponse result = null;
		try {
			before();
			doSomething();
			
			result = BaseResponse.success(data);
		} catch (BusinessException e) {
			logger.error("Throw business exception：", e);
			result =  BaseResponse.error(e.getCode(), e.getMsg());
		} catch (Exception e) {
			logger.error("Throw other exception(exclude business exception)：", e);
			String code = BaseErrorEnum.E14_SYS_Error.getCode();
			String msg = e.getMessage() == null ? new Date().toString() + ": " + e.getClass() : e.getMessage();
			result = BaseResponse.error(code, msg);
		}
		return result;
	}

	public void before() throws BusinessException {

	}

	public abstract void doSomething() throws BusinessException;

	public void put(String key, Object value){
		this.data.put(key, value);
	}
	
	public void putData(Object value){
		this.data.put("data", value);
	}
	
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
