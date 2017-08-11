<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${daoPackage}.${daoName}" >
	<resultMap id="BaseResultMap" type="${modelPackage}.${modelName}" >
	<#list columnInfos as columnInfo>
	<#if 'id' = columnInfo.columnName>
		<id column="${columnInfo.columnName}" property="${columnInfo.propertyName}" />
	<#else>
		<result column="${columnInfo.columnName}" property="${columnInfo.propertyName}" />
	</#if>
	</#list>
	</resultMap>

	<sql id="Base_Column_List" >
	<#list columnInfos as columnInfo>
		${columnInfo.columnName}<#if columnInfo_has_next>,</#if>
	</#list>
	</sql>

	<select id="queryForPage" resultMap="BaseResultMap">
		select <include refid="Base_Column_List" /> 
		from ${tableName}
		<#if (searchAbles?size>0) >
		<where>
			<#list searchAbles as columnInfo>
				<if test="${columnInfo.propertyName} != null and ${columnInfo.propertyName}.trim() != ''">
					and ${columnInfo.columnName} = ${r'#{'}${columnInfo.propertyName}}
				</if>
			</#list>
		</where>
		</#if>
        <choose>
            <when test="sidx != null and sidx.trim() != ''">
                order by ${r'#{sidx}'} ${r'#{order}'}
            </when>
			<otherwise>
                order by id desc
			</otherwise>
        </choose>
		<if test="offset != null and limit != null">
			limit ${r'#{offset}'}, ${r'#{limit}'}
		</if>
	</select>
	
	<select id="queryForList" resultMap="BaseResultMap">
		select <include refid="Base_Column_List" /> 
		from ${tableName}
		<#if (searchAbles?size>0) >
		<where>
			<#list searchAbles as columnInfo>
				<if test="${columnInfo.propertyName} != null and ${columnInfo.propertyName}.trim() != ''">
					and ${columnInfo.columnName} = ${r'#{'}${columnInfo.propertyName}}
				</if>
			</#list>
		</where>
		</#if>
        <choose>
            <when test="sidx != null and sidx.trim() != ''">
                order by ${r'#{sidx}'} ${r'#{order}'}
            </when>
			<otherwise>
                order by id desc
			</otherwise>
        </choose>
	</select>
	
	<select id="queryCount" resultType="int">
		select count(*) 
		from ${tableName}
		<#if (searchAbles?size>0) >
		<where>
			<#list searchAbles as columnInfo>
				<if test="${columnInfo.propertyName} != null and ${columnInfo.propertyName}.trim() != ''">
					and ${columnInfo.columnName} = ${r'#{'}${columnInfo.propertyName}}
				</if>
			</#list>
		</where>
		</#if>
	</select>
	
	<select id="get" resultMap="BaseResultMap" parameterType="java.lang.Integer" >
		select <include refid="Base_Column_List" />
		from ${tableName}
		where id =  ${r'#{id,jdbcType=INTEGER}'}
	</select>

	<insert id="save" parameterType="${modelPackage}.${modelName}" >
		<selectKey resultType="java.lang.Integer" keyProperty="id" order="AFTER" >
			SELECT LAST_INSERT_ID()
		</selectKey>
		insert into ${tableName} (
			<#list columnInfos as columnInfo>
			<#if 'id' != columnInfo.columnName>
			${columnInfo.columnName}<#if columnInfo_has_next>,</#if>
			</#if>
			</#list>)
		values (
			<#list columnInfos as columnInfo>
			<#if 'id' != columnInfo.propertyName>
			${r'#{'}${columnInfo.propertyName},jdbcType=${columnInfo.jdbcType}}<#if columnInfo_has_next>,</#if>
			</#if>
			</#list>)
	</insert>


	<update id="update" parameterType="${modelPackage}.${modelName}" >
		update ${tableName}
		<set>
			<#list columnInfos as columnInfo>
			<#if 'id' != columnInfo.columnName>
			<if test="${columnInfo.propertyName} != null" >
			${columnInfo.columnName}=${r'#{'}${columnInfo.propertyName},jdbcType=${columnInfo.jdbcType}}<#if columnInfo_has_next>,</#if>
			</if>
			</#if>
			</#list>
		</set>
		where id =  ${r'#{id,jdbcType=INTEGER}'}
	</update>

	<delete id="delete" parameterType="java.lang.Integer" >
		delete from ${tableName}
		where id = ${r'#{id,jdbcType=INTEGER}'}
	</delete>
	
	<delete id="deleteBatch">
		delete from ${tableName} where id in 
		<foreach item="id" collection="array" open="(" separator="," close=")">
			${r'#{id,jdbcType=INTEGER}'}
		</foreach>
	</delete>
</mapper>