package com.framework.common.code_generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component  
@ConfigurationProperties(prefix="gen") 
@Configuration
@PropertySource(value="classpath:generator.properties", ignoreResourceNotFound = true)
public class GeneratorConfig {

	@Value("packageName")
	private String packageName;
	
	@Value("tablePrefix")
	private String tablePrefix;
	
	@Value("templatePath")
	private String templatePath;
	
	@Value("outputPath")
	private String outputPath;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	
}
