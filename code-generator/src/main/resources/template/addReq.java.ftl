package ${addReqPackage};

<#list importList as importStr>
import ${importStr};
</#list>
import com.framework.common.web.req.BaseRequest;

/**
* 保存${tableAlias}的参数类
*/
public class ${addReqModel} extends BaseRequest {
	
	<#list addAbles as columnInfo>
	/**
	*	${columnInfo.columnComment}
	*/
	private ${columnInfo.propertyType} ${columnInfo.propertyName};
	
	</#list>
	
	<#list addAbles as columnInfo>
	public ${columnInfo.propertyType} get${columnInfo.methodName}(){
		return ${columnInfo.propertyName};
	}
	
	public void set${columnInfo.methodName}(${columnInfo.propertyType} ${columnInfo.propertyName}) {
		this.${columnInfo.propertyName} = ${columnInfo.propertyName};
	}
	
	</#list>
	
}