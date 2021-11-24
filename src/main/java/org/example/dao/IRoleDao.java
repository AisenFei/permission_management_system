package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.example.domain.Permission;
import org.example.domain.Role;

import java.util.List;

public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select role_id from users_role where user_id=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "org.example.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int userId) throws Exception;

    @Select("select * from role")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc")
    })
    public List<Role> findAll() throws Exception;

    @Insert("insert into role(role_name,role_desc) values(#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "org.example.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public Role findById(int id) throws Exception;

    @Delete("delete from users_role where role_id = #{id}")
    public void deleteFromUser_RoleByRoleId(int id) throws Exception;

    @Delete("delete from role_permission where role_id = #{id}")
    public void deleteFromRole_PermissionByRoleId(int id) throws Exception;

    @Delete("delete from role where id = #{id}")
    public void deleteRoleById(int id) throws Exception;

    @Select("select * from permission where id not in (select permission_id from role_permission where role_id = #{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionName",column = "permission_name"),
            @Result(property = "url",column = "url")
    })
    public List<Permission> findOtherPermissions(int id)throws Exception;

    @Insert("insert into role_permission values(#{role_id},#{p_id})")
    public void addPermissionToRole(@Param("role_id") int roleId,@Param("p_id") int pId) throws Exception;
}
