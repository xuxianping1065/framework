package com.framework.common.code_generator.model;

import org.springframework.util.StringUtils;

import com.framework.common.code_generator.utils.NameUtils;

public class ColumnInfo {

	private String columnName;
	
	private String columnType;
	
	private String columnComment;
	
	private String columnKey;
	
	private String extra;
	
	private String propertyName;
	
	private String propertyType;
	
	private String methodName;
	
	private Boolean nullAble = Boolean.FALSE;
	
	private Boolean searchAble = Boolean.FALSE;
	
	private Boolean listAble = Boolean.TRUE;
	
	private Boolean addAble = Boolean.FALSE;
	
	private Boolean modifyAble = Boolean.FALSE;
	
	private Boolean detailAble = Boolean.TRUE;


	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}


	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getPropertyName() {
		if( StringUtils.isEmpty(propertyName) ){
			return NameUtils.getLowerHumpName(columnName);
		}
		return propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getMethodName() {
		if( StringUtils.isEmpty(methodName) ){
			return NameUtils.getUpperHumpName(columnName);
		}
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getJdbcType() {
		return NameUtils.getJdbcType(columnType);
	}
	
	public String getPropertyType() {
		if( StringUtils.isEmpty(propertyType) ){
			return NameUtils.getPropertyType(columnType);
		}
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Boolean getNullAble() {
		return nullAble;
	}

	public void setNullAble(Boolean nullAble) {
		this.nullAble = nullAble;
	}

	public Boolean getSearchAble() {
		return searchAble;
	}

	public void setSearchAble(Boolean searchAble) {
		this.searchAble = searchAble;
	}

	public Boolean getListAble() {
		return listAble;
	}

	public void setListAble(Boolean listAble) {
		this.listAble = listAble;
	}

	public Boolean getAddAble() {
		return addAble;
	}

	public void setAddAble(Boolean addAble) {
		this.addAble = addAble;
	}

	public Boolean getModifyAble() {
		return modifyAble;
	}

	public void setModifyAble(Boolean modifyAble) {
		this.modifyAble = modifyAble;
	}
	
	public Boolean getDetailAble() {
		return detailAble;
	}

	public void setDetailAble(Boolean detailAble) {
		this.detailAble = detailAble;
	}
	
}
