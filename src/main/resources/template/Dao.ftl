<#assign modelName=modelBean.modelName >
package ${packageMap.dao};

import ${packageMap.mapper}.${modelName}Mapper;
import ${packageMap.model}.${modelName};

/**
* ${modelName}Dao 数据库访问接口
* @author ${author}
* @date ${date}
*/
public interface ${modelName}Dao extends BaseDao<${modelName}Mapper, ${modelName}> {

}
