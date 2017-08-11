package com.framework.common.web.api.req;

/**
 * 分页请求参数
 * @version 1.0
 * @author xxp
 */
public class BaseApiPageRequest extends BaseApiRequest {

	/**
	 *	页码 
	 */
	private int page;
	
	/**
	 *  每页数量
	 */
	private int rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
}
