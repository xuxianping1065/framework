package com.framework.common.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.common.util.StringUtils;

/**
 * Cookie工具类
 * 
 * @version 1.0
 * @author xxp
 */
public class CookieUtils {

	/**
	 * 新增cookie
	 * @param response 响应
	 * @param name cookie名称
	 * @param value cookie值
	 * @param maxAge cookie有效期
	 * @param domain cookie的有效域
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, String domain) {
		String val = "";
		try {
			val = URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Cookie cookie = new Cookie(name, val);
		if ( StringUtils.isNotEmpty(domain)) {
			cookie.setDomain(domain);
		}
		cookie.setPath("/");
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	
	/**
	 * 删除cookie
	 * @param request 请求
	 * @param response 响应
	 * @param name 需要删除cookie名称
	 * @param domain cookie的域
	 * @return cookie的值
	 */
	public static String removeCookie(HttpServletRequest request, HttpServletResponse response, String name, String domain) {
		Cookie cookie = getCookieByName(request, name);
		if (cookie == null) {
			return "fail";
		}
		Cookie newcookie = new Cookie(name, cookie.getValue());
		if ((domain != null) && (!"".equals(domain))) {
			newcookie.setDomain(domain);
		}
		newcookie.setPath("/");
		newcookie.setMaxAge(0);
		response.addCookie(newcookie);
		return cookie.getValue();
	}

	/**
	 * 查询cookie
	 * @param request 请求
	 * @param name cookie名称
	 * @return Cookie对象
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = cookieMap.get(name);
			return cookie;
		}
		return null;
	}

	/**
	 * 查询cookie的值
	 * @param request 请求
	 * @param name cookie名称
	 * @return cookie的值
	 */
	public static String getCookieValByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			String val = cookie.getValue();
			try {
				return URLDecoder.decode(val, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return cookie.getValue();
			}
		}
		return null;
	}

	/**
	 * 读取所有的cookie，以cookie的名称作为key、cookie作为值保存在Map中
	 * @param request 请求
	 * @return 保存所有cookie的Map
	 */
	private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
}
