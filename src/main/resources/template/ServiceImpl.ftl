<#assign modelName=modelBean.modelName >
package ${packageMap.serviceImpl};


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${packageMap.dao}.${modelName}Dao;
import ${packageMap.model}.${modelName};
import ${packageMap.service}.${modelName}Service;

/**
* ${modelName}Service 接口实现
* @author ${author}
* @date ${date}
*/
@Service
public class ${modelName}ServiceImpl implements ${modelName}Service{
private static final Logger logger = LoggerFactory.getLogger(${modelName}ServiceImpl.class);

    @Autowired
    private ${modelName}Dao ${modelName?uncap_first}Dao;

}
