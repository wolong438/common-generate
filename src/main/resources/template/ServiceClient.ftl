<#assign modelName=modelBean.modelName >
package ${packageMap.serviceClient};

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import ${packageMap.serviceApi}.${modelName}Api;

/**
* ${modelName}Service 访问客户端
* @author ${author}
* @date ${date}
*/
//@FeignClient("${appName}")
@Component
public interface ${modelName}Service extends ${modelName}Api{

}