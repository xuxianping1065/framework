package ${controllerPackage};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${modelPackage}.${modelName};
import ${servicePackage}.${serviceModel};
import ${addReqPackage}.${addReqModel};
import ${queryReqPackage}.${queryReqModel};
import ${updateReqPackage}.${updateReqModel};
import com.framework.common.exception.BusinessException;
import com.framework.common.web.controller.BaseAbstractController;
import com.framework.common.web.http.ServiceTemplate;
import com.framework.common.web.resp.BaseResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("${controllerRequestMapping}")
@Api(tags={"${tableAlias}"})
public class ${controllerModel} extends BaseAbstractController {

	@Autowired
	private ${serviceModel} ${serviceModel?uncap_first};
	
	@PostMapping(value = "/query", produces = "application/json;charset=UTF-8")
	@ApiOperation(value="通过查询条件查询${tableAlias}", notes="通过查询条件查询${tableAlias}")
	<#if (searchAbles?size > 0)>
	@ApiImplicitParams({
		<#list searchAbles as columnInfo>
		@ApiImplicitParam(name="${columnInfo.propertyName}", paramType="query", dataType="${columnInfo.propertyType}", value="${columnInfo.columnComment}")<#if columnInfo_has_next>,</#if>
		</#list>
	})
	</#if>
	public BaseResponse query(HttpServletRequest request, HttpServletResponse response, ${queryReqModel} ${queryReqModel?uncap_first}) {
		ServiceTemplate template = new ServiceTemplate() {
			@Override
			public void doSomething() throws BusinessException {
				Map<String, Object> paraMap = new HashMap<String, Object>();
				<#list searchAbles as columnInfo>
				paraMap.put("${columnInfo.propertyName}", ${queryReqModel?uncap_first}.get${columnInfo.methodName}());
				</#list>
				List<${modelName}> entities = ${serviceModel?uncap_first}.queryForList(paraMap);
				
				this.putData(entities);
			}
		};
		return template.service();
	}
	
	@PostMapping(value = "/get/{id}", produces = "application/json;charset=UTF-8")
	@ApiOperation(value="通过id查询${tableAlias}", notes="通过id查询${tableAlias}")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="path", dataType="string", value="id", required=true)
	})
	public BaseResponse get(HttpServletRequest request, HttpServletResponse response, @PathVariable("id")Integer id) {
		ServiceTemplate template = new ServiceTemplate() {
			@Override
			public void doSomething() throws BusinessException {
				${modelName} ${modelName?uncap_first} = ${serviceModel?uncap_first}.get(id);
				this.putData(${modelName?uncap_first});
			}
		};
		return template.service();
	}
	
	@PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
	@ApiOperation(value="保存${tableAlias}", notes="保存${tableAlias}")
	<#if (addAbles?size > 0)>
	@ApiImplicitParams({
		<#list addAbles as columnInfo>
		@ApiImplicitParam(name="${columnInfo.propertyName}", paramType="form", dataType="${columnInfo.propertyType}", value="${columnInfo.columnComment}"<#if (!columnInfo.nullAble)>, required=true</#if>)<#if columnInfo_has_next>,</#if>
		</#list>
	})
	</#if>
	public BaseResponse save(HttpServletRequest request, HttpServletResponse response, ${addReqModel} ${addReqModel?uncap_first}) {
		ServiceTemplate template = new ServiceTemplate() {
			@Override
			public void doSomething() throws BusinessException {
				${modelName} ${modelName?uncap_first} = new ${modelName}();
				BeanUtils.copyProperties(${addReqModel?uncap_first}, ${modelName?uncap_first});
				
				${serviceModel?uncap_first}.save(${modelName?uncap_first}, getUserInfo(request));
			}
		};
		return template.service();
	}
	
	@PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
	@ApiOperation(value="更新${tableAlias}", notes="更新${tableAlias}")
	<#if (modifyAbles?size > 0)>
	@ApiImplicitParams({
		<#list modifyAbles as columnInfo>
		@ApiImplicitParam(name="${columnInfo.propertyName}", paramType="form", dataType="${columnInfo.propertyType}", value="${columnInfo.columnComment}"<#if (!columnInfo.nullAble)>, required=true</#if>)<#if columnInfo_has_next>,</#if>
		</#list>
	})
	</#if>
	public BaseResponse update(HttpServletRequest request, HttpServletResponse response, ${updateReqModel} ${updateReqModel?uncap_first}) {
		ServiceTemplate template = new ServiceTemplate() {
			@Override
			public void doSomething() throws BusinessException {
				${modelName} ${modelName?uncap_first} = new ${modelName}();
				BeanUtils.copyProperties(${updateReqModel?uncap_first}, ${modelName?uncap_first});
				
				${serviceModel?uncap_first}.update(${modelName?uncap_first}, getUserInfo(request));
			}
		};
		return template.service();
	}
	
	@PostMapping(value = "/delete/{id}", produces = "application/json;charset=UTF-8")
	@ApiOperation(value="通过id删除${tableAlias}", notes="通过id删除${tableAlias}")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", paramType="path", dataType="string", value="id", required=true)
	})
	public BaseResponse delete(HttpServletRequest request, HttpServletResponse response, @PathVariable("id")Integer id) {
		ServiceTemplate template = new ServiceTemplate() {
			@Override
			public void doSomething() throws BusinessException {
				${serviceModel?uncap_first}.delete(id, getUserInfo(request));
			}
		};
		return template.service();
	}
	
	@PostMapping(value = "/deleteBatch", produces = "application/json;charset=UTF-8")
	@ApiOperation(value="通过id数组批量删除${tableAlias}", notes="通过id数组批量删除${tableAlias}")
	@ApiImplicitParams({
		@ApiImplicitParam(name="ids", paramType="form", dataType="Array", value="ids", required=true)
	})
	public BaseResponse deleteBatch(HttpServletRequest request, HttpServletResponse response, Integer[] ids) {
		ServiceTemplate template = new ServiceTemplate() {
			@Override
			public void doSomething() throws BusinessException {
				${serviceModel?uncap_first}.delete(ids);
			}
		};
		return template.service();
	}

}