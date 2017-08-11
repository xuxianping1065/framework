package ${updateReqPackage};

<#list importList as importStr>
import ${importStr};
</#list>
import com.framework.common.web.req.BaseRequest;

/**
* 更新${tableAlias}的参数类
*/
public class ${updateReqModel} extends BaseRequest {
	
	<#list modifyAbles as columnInfo>
	/**
	*	${columnInfo.columnComment}
	*/
	private ${columnInfo.propertyType} ${columnInfo.propertyName};
	
	</#list>
	
	<#list modifyAbles as columnInfo>
	public ${columnInfo.propertyType} get${columnInfo.methodName}(){
		return ${columnInfo.propertyName};
	}
	
	public void set${columnInfo.methodName}(${columnInfo.propertyType} ${columnInfo.propertyName}) {
		this.${columnInfo.propertyName} = ${columnInfo.propertyName};
	}
	
	</#list>
	
}