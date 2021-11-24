package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.example.domain.Permission;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in (select permission_id from role_permission where role_id=#{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionName",column = "permission_name"),
            @Result(property = "url",column = "url")
    })
    public List<Permission> findPermissionByRoleId(int id)throws Exception;

    @Select("select * from permission")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionName",column = "permission_name"),
            @Result(property = "url",column = "url")
    })
    public List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permission_name,url) values(#{permissionName},#{url})")
    public void save(Permission permission) throws Exception;

    @Delete("delete from role_permission where role_id = #{id}")
    public void deleteFromRole_Permission(int id) throws Exception;

    @Delete("delete from permission where id = #{id}")
    public void deleteById(int id)throws Exception;
}
