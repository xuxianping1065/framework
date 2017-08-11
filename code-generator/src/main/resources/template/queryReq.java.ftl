package ${queryReqPackage};

<#list importList as importStr>
import ${importStr};
</#list>
import com.framework.common.web.req.BasePageRequest;

/**
* 查询${tableAlias}的参数类
*/
public class ${queryReqModel} extends BasePageRequest {
	
	<#list searchAbles as columnInfo>
	/**
	*	${columnInfo.columnComment}
	*/
	private ${columnInfo.propertyType} ${columnInfo.propertyName};
	
	</#list>
	
	<#list searchAbles as columnInfo>
	public ${columnInfo.propertyType} get${columnInfo.methodName}(){
		return ${columnInfo.propertyName};
	}
	
	public void set${columnInfo.methodName}(${columnInfo.propertyType} ${columnInfo.propertyName}) {
		this.${columnInfo.propertyName} = ${columnInfo.propertyName};
	}
	
	</#list>
	
}