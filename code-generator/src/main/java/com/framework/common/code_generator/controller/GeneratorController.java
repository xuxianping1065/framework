package com.framework.common.code_generator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import com.framework.common.code_generator.config.GeneratorConfig;
import com.framework.common.code_generator.dao.GeneratorDao;
import com.framework.common.code_generator.model.ColumnInfo;
import com.framework.common.code_generator.model.ModelInfo;
import com.framework.common.code_generator.parameter.TableParameter;
import com.framework.common.code_generator.service.ModelService;
import com.framework.common.code_generator.utils.NameUtils;

@RestController
public class GeneratorController {
	
	@Autowired
	private GeneratorDao generatorDao;

	@Autowired
	private GeneratorConfig generatorConfig;
	
	@Autowired
	private ModelService modelService;
	
	@RequestMapping(value = "/tables", produces = "application/json;charset=UTF-8")
	public Map<String, Object> queryTables(NativeWebRequest request, TableParameter parameter){
		int offset = parameter.getStart() > 0 ? parameter.getStart() : 0;
		int limit = parameter.getLength() > 0 ? parameter.getLength() : 20;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", offset);
		map.put("limit", limit);
		map.put("tableName", parameter.getTableName());
		
		int total = generatorDao.queryTotal(map);
		
		List<ModelInfo> tables = generatorDao.queryTables(map);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", tables);
		result.put("recordsTotal", total);
		result.put("recordsFiltered", total);
		
		return result;
	}
	
	@RequestMapping(value = "/table", produces = "application/json;charset=UTF-8", method=RequestMethod.POST)
	public ModelInfo get(NativeWebRequest request, TableParameter parameter){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", parameter.getTableName());
		ModelInfo modelInfo = generatorDao.queryTable(map);
		modelInfo.setPackageName(generatorConfig.getPackageName());
		String tableName = modelInfo.getTableName();
		if( !StringUtils.isEmpty(generatorConfig.getTablePrefix()) ){
			tableName = modelInfo.getTableName().replace(generatorConfig.getTablePrefix(), "");
			modelInfo.setModelName( NameUtils.getUpperHumpName(tableName));
		}
		modelInfo.setControllerRequestMapping("/"+tableName.replace("_", "/"));

		List<ColumnInfo> columns = generatorDao.queryColumns(map);
		modelInfo.setColumnInfos(columns);
		
		return modelInfo;
	}
	
	@RequestMapping(value = "/generate", produces = "application/json;charset=UTF-8", method=RequestMethod.POST)
	public void create(NativeWebRequest request, ModelInfo modelInfo){
		
		modelService.generate(modelInfo);
	}
	
}
