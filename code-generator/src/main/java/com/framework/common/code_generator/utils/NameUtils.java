package com.framework.common.code_generator.utils;

import org.springframework.util.StringUtils;

public class NameUtils {
	
	public static String getLowerHumpName(String columnName){
		if( !StringUtils.isEmpty(columnName) ){
			columnName = columnName.toLowerCase();
			if( columnName.contains("_") ){
				StringBuffer result = new StringBuffer();
				String[] words = columnName.split("_");
				
				result.append(words[0]);
				if( words.length > 1 ){
					for( int i=1; i<words.length; i++ ){
						result.append(words[i].substring(0, 1).toUpperCase());
						result.append(words[i].substring(1));
					}
				}
				return result.toString();
			}
			return columnName;
		}
		return "";
	}
	
	public static String getUpperHumpName(String columnName){
		String lowerHumpName = getLowerHumpName(columnName);
		if( !StringUtils.isEmpty(lowerHumpName) ){
			lowerHumpName = lowerHumpName.substring(0, 1).toUpperCase() + lowerHumpName.substring(1);
			return lowerHumpName;
		}
		return "";
	}
	
	public static String getPropertyType(String columnType){
		if( !StringUtils.isEmpty(columnType) ){
			if( columnType.contains("varchar") ){
				return "String";
			} else if( columnType.contains("text") ){
				return "String";
			} else if( columnType.contains("int") ){
				return "Integer";
			} else if( columnType.contains("double") ){
				return "Double";
			} else if( columnType.contains("float") ){
				return "Float";
			} else if( columnType.contains("numberic") ){
				return "BigDecimal";
			} else if( columnType.contains("decimal") ){
				return "BigDecimal";
			} else if( "datetime".equals(columnType) ){
				return "Date";
			} else if( "date".equals(columnType) ){
				return "Date";
			} else if( "timestamp".equals(columnType) ){
				return "Date";
			}
		}
		return "";
	}
	
	public static String getJdbcType(String columnType){
		if( !StringUtils.isEmpty(columnType) ){
			if( columnType.contains("varchar") ){
				return "VARCHAR";
			} else if( columnType.contains("int") ){
				return "INTEGER";
			} else if( columnType.contains("double") ){
				return "NUMERIC";
			} else if( columnType.contains("numberic") ){
				return "NUMERIC";
			} else if( columnType.contains("decimal") ){
				return "NUMERIC";
			} else if( columnType.contains("date") ){
				return "TIMESTAMP";
			} else if( columnType.contains("time") ){
				return "TIMESTAMP";
			}else{
				return columnType.toUpperCase();
			}
		}
		return "";
	}
	
	public static String getGetter(String propertyName, String propertyType){
		if( !StringUtils.isEmpty(propertyName) ){
			StringBuffer getter = new StringBuffer();
			getter.append("private "+propertyType+" get"+propertyName +"(){\r\n");
			getter.append("\t\treturn "+propertyName+";\r\n");
			getter.append("\t}");
			
			return getter.toString();
		}
		return "";
	}
	
	public static String getSetter(String propertyName, String propertyType){
		if( !StringUtils.isEmpty(propertyName) ){
			StringBuffer setter = new StringBuffer();
			setter.append("private void set"+propertyName +"("+ propertyType +" "+propertyType+"){\r\n");
			setter.append("\t\tthis."+propertyName+"="+propertyName+";\r\n");
			setter.append("\t}");
			
			return setter.toString();
		}
		return "";
	}
	
	
	public static String getImportStr(String columnType){
		if( !StringUtils.isEmpty(columnType) ){
			if( columnType.contains("numberic") ){
				return "java.math.BigDecimal";
			} else if( columnType.contains("decimal") ){
				return "java.math.BigDecimal";
			} else if( columnType.contains("date") ){
				return "java.util.Date";
			} else if( columnType.contains("time") ){
				return "java.util.Date";
			}
		}
		return "";
	}
}
