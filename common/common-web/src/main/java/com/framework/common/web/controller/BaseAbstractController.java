package com.framework.common.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.framework.common.model.OperatorUser;
import com.framework.common.web.util.IpUtils;

public class BaseAbstractController {

	public OperatorUser getUserInfo(HttpServletRequest request){
		String ip = IpUtils.getIpAddr(request);
		return OperatorUser.newInstance(1, ip);
	}
}
