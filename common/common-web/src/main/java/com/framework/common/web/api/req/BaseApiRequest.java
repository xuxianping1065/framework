package com.framework.common.web.api.req;

/**
 * Api接口基础请求参数
 * @version 1.0
 * @author xxp
 */
public class BaseApiRequest {

	/**
	 * 签名
	 */
	private String signature;
	
	/**
	 * 应用号
	 */
	private String appid;
	
	/**
	 * 版本号
	 */
	private String version;
	
	/**
	 * 设备号
	 */
	private String deviceNo;
	
	/**
	 * 平台
	 */
	private String platfrom;
	
	/**
	 * 凭证
	 */
	private String token;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getPlatfrom() {
		return platfrom;
	}

	public void setPlatfrom(String platfrom) {
		this.platfrom = platfrom;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
