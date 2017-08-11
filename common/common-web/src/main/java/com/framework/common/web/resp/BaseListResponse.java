package com.framework.common.web.resp;

import java.util.List;

/**
 * 包含List的返回结果
 * @version 1.0
 * @author xxp
 */
public class BaseListResponse<T> extends BaseResponse {
	private static final long serialVersionUID = 1L;

	public BaseListResponse(List<T> dataList) {
		this.putData(dataList);
	}
}
