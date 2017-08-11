package com.framework.common.web.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * IP工具类
 * 
 * @version 1.0
 * @author xxp
 */
public class IpUtils {

	/**
	 * 获得IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");

		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}

		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}

		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getRemoteAddr();
			if ((ipAddress.equals("127.0.0.1")) || (ipAddress.equals("0:0:0:0:0:0:0:1"))) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}

		if ((ipAddress != null) && (ipAddress.length() > 15)) {
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
}
