package com.framework.common.model;

/**
 *	操作人信息
 */
public class OperatorUser {

	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 用户ip
	 */
	private String userIp;
	
	private OperatorUser(){
		
	}
	
	/**
	 * 初始化对象
	 * @param userId 用户id
	 * @param userIp 用户ip
	 * @return 操作人对象
	 */
	public static OperatorUser newInstance(Integer userId, String userIp){
		OperatorUser operatorUser = new OperatorUser();
		operatorUser.setUserId(userId);
		operatorUser.setUserIp(userIp);
		return operatorUser;
	}
	
	/**
	 * 初始化对象
	 * @param username 用户名
	 * @param userIp 用户ip
	 * @return 操作人对象
	 */
	public static OperatorUser newInstance(String username, String userIp){
		OperatorUser operatorUser = new OperatorUser();
		operatorUser.setUsername(username);
		operatorUser.setUserIp(userIp);
		return operatorUser;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

}
