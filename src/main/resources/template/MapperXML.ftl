<#assign modelName=modelBean.modelName >
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageMap.mapper}.${modelName}Mapper">
    <resultMap type="${modelName}" id="BaseResult">
    <#list modelBean.properties as propertyBean>
        <result property="${propertyBean.property}" column="${propertyBean.column}" jdbcType="${propertyBean.jdbcType}" />
    </#list>
    </resultMap>

    <sql id="BaseTable">
        ${modelName}
    </sql>

    <sql id="BaseColumn">

    </sql>

    <select id="countByModel" parameterType="${modelName}" resultType="Integer">
        select count(1) from
        <include refid="BaseTable"/>
        <trim prefix="where" suffixOverrides="and">
            1 = 1
        </trim>
    </select>

</mapper>