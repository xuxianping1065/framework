package ${modelPackage};

<#list importList as importStr>
import ${importStr};
</#list>

import com.framework.common.model.OperatorEntity;
import com.framework.common.model.StateEntity;

/**
* ${tableAlias}
*/
public class ${modelName} implements OperatorEntity, StateEntity {
	private static final long serialVersionUID = 1L;
	
    <#list columnInfos as columnInfo>
	/**
	*	${columnInfo.columnComment}
	*/
	private ${columnInfo.propertyType} ${columnInfo.propertyName};
	
	</#list>

	<#list columnInfos as columnInfo>
	/**
	* 获取：${columnInfo.columnComment}
	*/
	public ${columnInfo.propertyType} get${columnInfo.methodName}(){
		return ${columnInfo.propertyName};
	}
	
	/**
	* 设置：${columnInfo.columnComment}
	*/
	public void set${columnInfo.methodName}(${columnInfo.propertyType} ${columnInfo.propertyName}) {
		this.${columnInfo.propertyName} = ${columnInfo.propertyName};
	}

	</#list>
}