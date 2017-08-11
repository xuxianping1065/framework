package com.framework.common.web.resp;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.framework.common.constant.BaseErrorEnum;

/**
 * 基础返回结果
 * @version 1.0
 * @author xxp
 */
@JsonInclude(value=Include.NON_NULL)
public class BaseResponse extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;

	
	protected BaseResponse() {
	}
	
	/**
	 * @param code 返回码
	 * @param msg 返回信息
	 */
	protected BaseResponse(String code, String msg) {
		this.put("code", code);
		this.put("msg", msg);
	}
	
	/**
	 * @param code 返回码
	 * @param msg 返回信息
	 */
	protected BaseResponse(BaseErrorEnum baseErrorEnum) {
		this.put("code", baseErrorEnum.getCode());
		this.put("msg", baseErrorEnum.getMsg());
	}
	
	/**
	 * 创建成功返回结果
	 * @return
	 */
	public static BaseResponse success(){
		BaseResponse result = new BaseResponse();
		result.put("code", BaseErrorEnum.E0_SUCCESS.getCode());
		result.put("msg", BaseErrorEnum.E0_SUCCESS.getMsg());
		return result;
	}
	
	/**
	 * 创建成功返回结果
	 * @return
	 */
	public static BaseResponse success(Object data){
		BaseResponse result = new BaseResponse();
		result.put("code", BaseErrorEnum.E0_SUCCESS.getCode());
		result.put("msg", BaseErrorEnum.E0_SUCCESS.getMsg());
		if( data instanceof Map ){
			result.putAll((Map) data);
		}else{
			result.put("data", data);
		}
		
		return result;
	}
	
	/**
	 * 创建成功返回
	 * @return
	 */
	public static BaseResponse error(String code, String msg){
		return new BaseResponse(code, msg);
	}
	
	/**
	 * 创建成功返回
	 * @return
	 */
	public static BaseResponse error(BaseErrorEnum baseErrorEnum){
		return new BaseResponse(baseErrorEnum);
	}

	public void putData(Object obj){
		this.put("data", obj);
	}

}
