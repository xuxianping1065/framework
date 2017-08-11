package com.framework.common.web.resp;

import java.util.List;

import com.framework.common.query.Page;

/**
 * 带分页参数的返回结果
 * 
 * @version 1.0
 * @author xxp
 */
public class BasePageResponse<T> extends BaseListResponse<T> {
	private static final long serialVersionUID = 1L;

	public BasePageResponse(Page<T> page) {
		super(page.getList());
		this.put("total", page.getTotal());
		this.put("pages", page.getPages());
		this.put("pageSize", page.getPageSize());
		this.put("pageNum", page.getPageNum());
	}

	public BasePageResponse(Page<T> page, List<T> dataList) {
		super(dataList);
		this.put("total", page.getTotal());
		this.put("pages", page.getPages());
		this.put("pageSize", page.getPageSize());
		this.put("pageNum", page.getPageNum());
	}


}
