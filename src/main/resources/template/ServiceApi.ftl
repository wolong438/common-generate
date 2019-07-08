<#assign modelName=modelBean.modelName >
package ${packageMap.serviceApi};


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ${packageMap.model}.${modelName};
import com.sinosoft.sss.commons.transfer.SingleDataResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
* ${modelName}Service 对外暴露接口
* @author ${author}
* @date ${date}
*/
@Api(value="/${modelName?uncap_first}", tags="${modelName}操作接口")
@RequestMapping("/${modelName?uncap_first}")
public interface ${modelName}Api {

    @ApiOperation(value = "Api ping")
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    SingleDataResult<Object> ping();

}
