package com.framework.common.code_generator.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import com.framework.common.code_generator.config.GeneratorConfig;
import com.framework.common.code_generator.model.ModelInfo;
import com.framework.common.code_generator.service.ModelService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	GeneratorConfig generatorConfig;
	
	public void generate(ModelInfo modelInfo) {
		List<Template> templates = getTemplates();
		for( Template template : templates ){
			File file =  getFile(template.getName(), modelInfo);
			
			if( null != file ){
				generateFile(modelInfo, template, file);
			}
		}
	}

	private List<Template> getTemplates() {
		try {
			List<Template> templates = new ArrayList<Template>();
			File templateDir = ResourceUtils.getFile(generatorConfig.getTemplatePath());
			Configuration configuration = new Configuration();
			configuration.setDirectoryForTemplateLoading(templateDir);
			for( File templateFile : templateDir.listFiles() ){
				
				Template template = configuration.getTemplate(templateFile.getName());
				template.setEncoding("UTF-8");
				
				templates.add(template);
			}
			return templates;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 获取文件名
	 */
	private File getFile(String template, ModelInfo modelInfo){
		String outputPath = generatorConfig.getOutputPath() + File.separator;
		
		switch (template) {
			case "model.java.ftl":
				return createFile(outputPath, modelInfo.getModelPackage(), modelInfo.getModelName()+".java");
			case "dao.java.ftl":
				return createFile(outputPath, modelInfo.getDaoPackage(), modelInfo.getDaoName()+".java");
			case "dao.xml.ftl":
				return createFile(outputPath, "", modelInfo.getDaoName()+".xml");
			case "service.java.ftl":
				return createFile(outputPath, modelInfo.getServicePackage(), modelInfo.getServiceModel()+".java");
			case "serviceImpl.java.ftl":
				return createFile(outputPath, modelInfo.getServiceImplPackage(), modelInfo.getServiceImplModel()+".java");
			case "controller.java.ftl":
				return createFile(outputPath, modelInfo.getControllerPackage(), modelInfo.getControllerModel()+".java");
			case "addReq.java.ftl":
				return createFile(outputPath, modelInfo.getAddReqPackage(), modelInfo.getAddReqModel()+".java");
			case "queryReq.java.ftl":
				return createFile(outputPath, modelInfo.getQueryReqPackage(), modelInfo.getQueryReqModel()+".java");
			case "updateReq.java.ftl":
				return createFile(outputPath, modelInfo.getUpdateReqPackage(), modelInfo.getUpdateReqModel()+".java");
			case "list.html.ftl":
				return createFile(outputPath, "", "list.html");
			case "list.js.ftl":
				return createFile(outputPath, "", "list.js");
			default:
				return null;
		}
	}

	private File createFile(String packagePath, String packageName, String fileName) {
		if( !StringUtils.isEmpty(packageName)){
			packagePath += packageName.replace(".", File.separator);
		}
		File dir = new File(packagePath);
		if( !dir.exists() ){
			dir.mkdirs();
		}
		String fileFullName = packagePath + File.separator + fileName;
		
		return new File(fileFullName);
	}
	
	
	private void generateFile(ModelInfo modelInfo, Template template, File file) {
		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			template.process(modelInfo, writer);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
