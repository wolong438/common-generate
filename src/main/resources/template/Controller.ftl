<#assign modelName=modelBean.modelName >
package ${packageMap.controller};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ${packageMap.serviceApi}.${modelName}Api;
import ${packageMap.service}.${modelName}Service;
import com.sinosoft.sss.commons.transfer.SingleDataResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
* ${modelName}Controller控制器
* @author ${author}
* @date ${date}
*/
@RestController
public class ${modelName}Controller implements ${modelName}Api{
private static final Logger logger = LoggerFactory.getLogger(${modelName}Controller.class);

@Autowired
private ${modelName}Service ${modelName?uncap_first}Service;

    @Override
    public SingleDataResult<Object> ping() {
        SingleDataResult<Object> result = new SingleDataResult<Object>();
        result.setSuccess(true);
        result.setMessage("pong");
        return result;
    }

}
