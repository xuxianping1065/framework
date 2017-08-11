package ${serviceImplPackage};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.common.service.AbstractBaseServiceImpl;
import com.framework.common.dao.BaseDao;
import ${daoPackage}.${daoName};
import ${modelPackage}.${modelName};
import ${servicePackage}.${serviceModel};

/**
 *	${tableAlias}Service实现类
 */
@Service
public class ${serviceImplModel} extends AbstractBaseServiceImpl<${modelName}> implements ${serviceModel}{

	@Autowired
	private ${daoName} ${daoName?uncap_first};
	
	@Override
	public BaseDao<${modelName}> getBaseDao() {
		return ${daoName?uncap_first};
	}
	
}
