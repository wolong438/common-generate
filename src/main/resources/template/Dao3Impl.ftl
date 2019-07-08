<#assign modelName=modelBean.modelName >
package ${packageMap.daoImpl};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ${packageMap.dao}.${modelName}Dao;
import ${packageMap.mapper}.${modelName}Mapper;
import ${packageMap.mapper}.BaseMapper;
import ${packageMap.model}.${modelName};

/**
* ${modelName}Dao 数据库访问接口实现
* @author ${author}
* @date ${date}
*/
@Component
public class ${modelName}DaoImpl extends BaseDaoImpl<${modelName}Mapper, ${modelName}> implements ${modelName}Dao{
    private static final Logger logger = LoggerFactory.getLogger(${modelName}DaoImpl.class);

    @Autowired
    private ${modelName}Mapper mapper;

    @Override
    public BaseMapper<${modelName}> getMapper() {
        return mapper;
    }

}
