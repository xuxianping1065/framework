package com.framework.common.code_generator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.framework.common.code_generator.utils.NameUtils;

public class ModelInfo {
	
	private String tableName;
	
	private String tableAlias;
	
	private String packageName;
	
	private String modelPackage;
	private String modelName;
	
	private String daoPackage;
	private String daoName;
	
	private String servicePackage;
	private String serviceModel;
	
	private String serviceImplPackage;
	private String serviceImplModel;
	
	private String controllerPackage;
	private String controllerModel;
	private String controllerRequestMapping;
	
	private String addReqPackage;
	private String addReqModel;
	
	private String updateReqPackage;
	private String updateReqModel;
	
	private String queryReqPackage;
	private String queryReqModel;
	
	
	private List<String> importList = new ArrayList<String>();
	
	private List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();

	
	public List<ColumnInfo> getListAbles(){
		List<ColumnInfo> lists = new ArrayList<ColumnInfo>();
		for( ColumnInfo columnInfo: getColumnInfos()){
			if(columnInfo.getListAble()){
				lists.add(columnInfo);
			}
		}
		return lists;
	}
	public List<ColumnInfo> getSearchAbles(){
		List<ColumnInfo> lists = new ArrayList<ColumnInfo>();
		for( ColumnInfo columnInfo: getColumnInfos()){
			if(columnInfo.getSearchAble()){
				lists.add(columnInfo);
			}
		}
		return lists;
	}
	public List<ColumnInfo> getAddAbles(){
		List<ColumnInfo> lists = new ArrayList<ColumnInfo>();
		for( ColumnInfo columnInfo: getColumnInfos()){
			if(columnInfo.getAddAble()){
				lists.add(columnInfo);
			}
		}
		return lists;
	}
	public List<ColumnInfo> getModifyAbles(){
		List<ColumnInfo> lists = new ArrayList<ColumnInfo>();
		for( ColumnInfo columnInfo: getColumnInfos()){
			if(columnInfo.getModifyAble()){
				lists.add(columnInfo);
			}
		}
		return lists;
	}
	
	public Set<String> getImportList(){
		Set<String> lists = new HashSet<String>();
		for( ColumnInfo columnInfo: getColumnInfos()){
			String importStr = NameUtils.getImportStr(columnInfo.getColumnType());
			if( !StringUtils.isEmpty(importStr)){
				lists.add(importStr);
			}
		}
		return lists;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableAlias() {
		return tableAlias;
	}
	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getModelPackage() {
		if( StringUtils.isEmpty(modelPackage) ){
			this.modelPackage = packageName+".model";
		}
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	public String getModelName() {
		if( StringUtils.isEmpty(modelName) ){
			this.modelName = NameUtils.getUpperHumpName(tableName);
		}
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public List<ColumnInfo> getColumnInfos() {
		return columnInfos;
	}

	public void setColumnInfos(List<ColumnInfo> columnInfos) {
		this.columnInfos = columnInfos;
	}

	public String getDaoPackage() {
		if( StringUtils.isEmpty(daoPackage) ){
			this.daoPackage = packageName+".dao";
		}
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	public String getDaoName() {
		if( StringUtils.isEmpty(daoName) ){
			this.daoName = getModelName()+"Dao";
		}
		return daoName;
	}
	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}
	public String getServicePackage() {
		if( StringUtils.isEmpty(servicePackage) ){
			this.servicePackage = packageName+".service";
		}
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getServiceModel() {
		if( StringUtils.isEmpty(serviceModel) ){
			this.serviceModel = modelName + "Service";
		}
		return serviceModel;
	}
	public void setServiceModel(String serviceModel) {
		this.serviceModel = serviceModel;
	}
	public String getServiceImplPackage() {
		if( StringUtils.isEmpty(serviceImplPackage) ){
			this.serviceImplPackage = getServicePackage() + ".impl";
		}
		return serviceImplPackage;
	}
	public void setServiceImplPackage(String serviceImplPackage) {
		this.serviceImplPackage = serviceImplPackage;
	}
	public String getServiceImplModel() {
		if( StringUtils.isEmpty(serviceImplModel) ){
			this.serviceImplModel = modelName + "ServiceImpl";
		}
		return serviceImplModel;
	}
	public void setServiceImplModel(String serviceImplModel) {
		this.serviceImplModel = serviceImplModel;
	}
	public String getControllerPackage() {
		if( StringUtils.isEmpty(controllerPackage) ){
			this.controllerPackage = packageName + ".web.controller";
		}
		return controllerPackage;
	}
	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}
	public String getControllerModel() {
		if( StringUtils.isEmpty(controllerModel) ){
			this.controllerModel = modelName + "Controller";
		}
		return controllerModel;
	}
	public void setControllerModel(String controllerModel) {
		this.controllerModel = controllerModel;
	}
	public String getControllerRequestMapping() {
		return controllerRequestMapping;
	}
	public void setControllerRequestMapping(String controllerRequestMapping) {
		this.controllerRequestMapping = controllerRequestMapping;
	}
	
	public String getAddReqPackage() {
		if( StringUtils.isEmpty(addReqPackage) ){
			this.addReqPackage = packageName + ".web.req";
		}
		return addReqPackage;
	}
	public void setAddReqPackage(String addReqPackage) {
		this.addReqPackage = addReqPackage;
	}
	public String getAddReqModel() {
		if( StringUtils.isEmpty(addReqModel) ){
			this.addReqModel = modelName + "AddReq";
		}
		return addReqModel;
	}
	public void setAddReqModel(String addReqModel) {
		this.addReqModel = addReqModel;
	}
	public String getUpdateReqPackage() {
		if( StringUtils.isEmpty(updateReqPackage) ){
			this.updateReqPackage = packageName + ".web.req";
		}
		return updateReqPackage;
	}
	public void setUpdateReqPackage(String updateReqPackage) {
		this.updateReqPackage = updateReqPackage;
	}
	public String getUpdateReqModel() {
		if( StringUtils.isEmpty(updateReqModel) ){
			this.updateReqModel = modelName + "UpdateReq";
		}
		return updateReqModel;
	}
	public void setUpdateReqModel(String updateReqModel) {
		this.updateReqModel = updateReqModel;
	}
	public String getQueryReqPackage() {
		if( StringUtils.isEmpty(queryReqPackage) ){
			this.queryReqPackage = packageName + ".web.req";
		}
		return queryReqPackage;
	}
	public void setQueryReqPackage(String queryReqPackage) {
		this.queryReqPackage = queryReqPackage;
	}
	public String getQueryReqModel() {
		if( StringUtils.isEmpty(queryReqModel) ){
			this.queryReqModel = modelName + "QueryReq";
		}
		return queryReqModel;
	}
	public void setQueryReqModel(String queryReqModel) {
		this.queryReqModel = queryReqModel;
	}
	
}
