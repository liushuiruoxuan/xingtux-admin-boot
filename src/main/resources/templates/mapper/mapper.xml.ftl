<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">
    <!-- 开启二级缓存 -->
    <#--    <cache type="${cacheClassName}"/>-->
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
        <#list table.fields as field>
            <#if field.keyFlag><#--生成主键排在第一位-->
                <id column="${field.name}" property="${field.propertyName}" javaType="${field.propertyType}"/>
            </#if>
        </#list>
        <#list table.commonFields as field><#--生成公共字段 -->
            <result column="${field.name}" property="${field.propertyName}" javaType="${field.propertyType}"/>
        </#list>
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
                <result column="${field.name}" property="${field.propertyName}" javaType="${field.propertyType}"/>
            </#if>
        </#list>
    </resultMap>

    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
        <#list table.commonFields as field>
            ${field.columnName},
        </#list>
        ${table.fieldNames}
    </sql>

    <sql id="list_where">
        <where>
            <#list table.fields as field>
                <#if field.propertyName =="deleted">
                    and deleted = 0
                <#elseif field.propertyName == "del_flag">
                    and del_flag = 0
                <#elseif field.propertyType == "String">
                    <if test="${field.propertyName} != null and ${field.propertyName} !=''">
                        and ${field.name} = ${r"#{"}${field.propertyName}${r"}"}
                    </if>
                <#elseif field.keyFlag>
                    <if test="${field.propertyName}s != null and ${field.propertyName}s.size() > 0">
                        and ${field.name} in
                        <foreach collection="${field.propertyName}s" item="item" index="index" open="(" close=")" separator=",">
                            ${r"#{"}item${r"}"}
                        </foreach>
                    </if>
                    <if test="${field.propertyName} != null">
                        and ${field.name} = ${r"#{"}${field.propertyName}${r"}"}
                    </if>
                <#else>
                    <if test="${field.propertyName} != null">
                        and ${field.name} = ${r"#{"}${field.propertyName}${r"}"}
                    </if>
                </#if>
            </#list>
        </where>
    </sql>
    <sql id="update_where">
        <where>
            <#list table.fields as field>
                <#if field.keyFlag>
                    <if test="${field.propertyName} != null">
                        and ${field.name} = ${r"#{"}${field.propertyName}${r"}"}
                    </if>
                </#if>
            </#list>
        </where>
    </sql>
    <select id="get${entity}List" parameterType="${package.Entity}.${entity}" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${table.name}
        <include refid="list_where"/>
        order by create_time desc
    </select>

    <select id="get${entity}One" parameterType="${package.Entity}.${entity}" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${table.name}
        <include refid="list_where"/>
        limit 1
    </select>

    <insert id="insert${entity}" parameterType="${package.Entity}.${entity}" useGeneratedKeys="true" keyColumn="id" keyProperty="id" >
        insert into ${table.name}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list table.fields as field>
                <#if !field.keyFlag>
                    <if test="${field.propertyName} != null">
                        ${field.name},
                    </if>
                </#if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list table.fields as field>
                <#if !field.keyFlag>
                    <if test="${field.propertyName} != null">
                        ${r"#{"}${field.propertyName}${r"}"},
                    </if>
                </#if>
            </#list>
        </trim>
    </insert>

    <insert id="insertBatch${entity}">
        insert into ${table.name}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list table.fields as field>
                <#if !field.keyFlag>
                    <if test="${field.propertyName} != null">
                        ${field.name},
                    </if>
                </#if>
            </#list>
        </trim>
        values
        <foreach collection="list" item="item" index="index" separator=",">
            <trim prefix="(" suffix=")" suffixOverrides=",">
                <#list table.fields as field>
                    <#if !field.keyFlag>
                        <if test="${field.propertyName} != null">
                            ${r"#{"}item.${field.propertyName}${r"}"},
                        </if>
                    </#if>
                </#list>
            </trim>
        </foreach>
    </insert>

    <update id="update${entity}" parameterType="${package.Entity}.${entity}" useGeneratedKeys="true" keyColumn="id" keyProperty="id" >
        update ${table.name}
        <set>
            <#list table.fields as field>
                <#if !field.keyFlag>
                    <if test="${field.propertyName} != null">
                        ${field.name} = ${r"#{"}${field.propertyName}${r"}"},
                    </if>
                </#if>
            </#list>
        </set>
        <include refid="update_where"/>
    </update>


    <update id="updateBatch${entity}">
        <foreach collection="list" item="item" index="index" separator=";">
            update ${table.name}
            <set>
                <#list table.fields as field>
                    <#if !field.keyFlag>
                        ${field.name} = ${r"#{"}item.${field.propertyName}${r"}"},
                    </#if>
                </#list>
            </set>
            <where>
                <#list table.fields as field>
                    <#if field.keyFlag>
                        ${field.name} = ${r"#{"}item.${field.propertyName}${r"}"}
                    </#if>
                </#list>
            </where>
        </foreach>
    </update>

    <update id="delete${entity}" parameterType="${package.Entity}.${entity}">
        <!-- 逻辑删除 -->
        update ${table.name}
        <set>
            <#list table.fields as field>
                <#if !field.keyFlag>
                    <#if field.propertyName =="del_flag">
                        del_flag = 1
                    </#if>
                </#if>
            </#list>
        </set>
        <include refid="update_where"/>
    </update>

    <update id="deleteBatch${entity}" parameterType="${package.Entity}.${entity}">
        update ${table.name}
        <set>
            <#list table.fields as field>
                <#if !field.keyFlag>
                    <#if field.propertyName =="del_flag">
                        del_flag = 1
                    </#if>
                </#if>
            </#list>
        </set>
        <where>
            <#list table.fields as field>
                <#if field.keyFlag>
                    ${field.name} in
                    <foreach collection="${field.name}s" item="item" index="index" open="(" close=")" separator=",">
                        ${r"#{"}item.${field.propertyName}${r"}"}
                    </foreach>
                </#if>
            </#list>
        </where>
    </update>
</mapper>
