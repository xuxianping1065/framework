package com.framework.common.code_generator.dao;

import java.util.List;
import java.util.Map;

import com.framework.common.code_generator.model.ColumnInfo;
import com.framework.common.code_generator.model.ModelInfo;

public interface GeneratorDao {

	public List<ModelInfo> queryTables(Map<String, Object> map);
	
	public int queryTotal(Map<String, Object> map);
	
	public ModelInfo queryTable(Map<String, Object> map);
	
	public List<ColumnInfo> queryColumns(Map<String, Object> map);
	
}
