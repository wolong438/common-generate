package ${packageMap.model};

import java.util.Date;

/**
* ${modelBean.modelName} 实体
* @author ${author}
* @date ${date}
*/
public class ${modelBean.modelName} {
<#list modelBean.properties as propertyBean>
    <#if propertyBean.comment??>
    /** ${propertyBean.comment} **/
    </#if>
    private ${propertyBean.javaType} ${propertyBean.property};

</#list>
<#list modelBean.properties as propertyBean>
    public ${propertyBean.javaType} get${propertyBean.property?cap_first}() {
      return ${propertyBean.property};
    }

    public void set${propertyBean.property?cap_first}(${propertyBean.javaType} ${propertyBean.property}) {
      this.${propertyBean.property} = ${propertyBean.property};
    }
</#list>
}