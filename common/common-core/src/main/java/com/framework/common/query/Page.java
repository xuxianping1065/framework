package com.framework.common.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 分页数据封装对象
 * @version 1.0
 * @author xxp
 */
public class Page<E> extends ArrayList<E> {
	private static final long serialVersionUID = 1L;

	/**
	 * 每页记录数
	 */
	private int pageSize;

	/**
	 * 当前页码
	 */
	private int pageNum;

	/**
	 * 总记录数
	 */
	private int total;

	/**
	 * 总页数
	 */
	private int pages;

	/**
	 * 当前页开始位置
	 */
	private int start;

	/**
	 * 当前页结束位置
	 */
	private int end;

	public Page(Collection<E> list) {
		super(list);
	}

	public Page(int pageNum, int pageSize) {
		this(pageNum, pageSize, 0);
	}

	public Page(int offset, int pageSize, boolean falg) {
		this(offset, pageSize, 0, falg);
	}

	public Page(int pageNum, int pageSize, int total) {
		super(pageSize);
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.total = total;
		this.pages = total % this.pageSize > 0 ? total / this.pageSize + 1 : total / this.pageSize;
		this.start = (pageNum > 0 ? (pageNum - 1) * pageSize : 0);
		this.end = pageNum * pageSize;
	}

	public Page(int offset, int pageSize, int total, boolean falg) {
		super(pageSize);
		this.pageSize = pageSize;
		this.pageNum = offset / this.pageSize + 1;
		this.total = total;
		this.pages = total % this.pageSize > 0 ? total / this.pageSize + 1 : total / this.pageSize;
		this.start = offset;
		this.end = offset + this.pageSize;
	}
	
	public List<E> getList(){
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
