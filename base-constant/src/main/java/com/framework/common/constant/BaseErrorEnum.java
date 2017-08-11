package com.framework.common.constant;

public enum BaseErrorEnum {

	E0_SUCCESS("0", "请求成功"), 

    E_1_FAIL_SYS("-1", "请求系统失败"), 

    E_2_FAIL_BIZ("-2", "请求业务失败"), 

    E_3_UN_Login("-3", "用户未登录"), 

    E_4_UN_Authc("-4", "无权限访问"), 

    E_5_FAIL_Sign("-5", "签名验证失败"), 

    E10_Para_Error("10", "参数错误"), 

    E11_Para_Null("11", "参数为空"), 

    E12_Vcode_Error("12", "验证码错误"), 

    E13_DB_Error("13", "数据库错误"), 

    E14_SYS_Error("14", "系统错误"), 

    E15_File_Error("15", "文件错误"), 

    E16_Data_NotExist("16", "数据不存在"), 

    E17_Data_ChangeError("17", "数据转换错误"), 

    E18_Property_Error("18", "Property文件处理错误"), 

    E19_Redis_Error("19", "Redis错误"), 

    E20_Json_Error("20", "Json错误"), 

    E21_Obj_NotExist("21", "对象不存在"), 

    E22_ObjType_Error("22", "类型错误"), 

    E23_Cache_NotSupport("23", "不支持此缓存"), 

    E24_Http_Error("24", "Http请求错误"), 

    E25_HttpResp_Error("25", "Http返回信息错误"), 

    E26_XMLParser_Error("26", "XML解析错误"), 

    E27_Sign_Error("27", "第三方签名失败"), 

    E28_MethodNotSupport_Error("28", "不支持此方法"), 

    E29_ThirdAPI_Error("29", "调用第三方服务失败");
	
	private String code;
	
	private String msg;
	
	private BaseErrorEnum(String code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
