package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.example.domain.Role;
import org.example.domain.UserInfo;

import java.util.List;

public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phone_num"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "org.example.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;


    @Select("select * from users")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phone_num"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "org.example.dao.IRoleDao.findRoleByUserId"))
    })
    public List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(email,username,password,phone_num,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phone_num"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "org.example.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findById(int id) throws Exception;

    @Select("select * from role where id not in (select role_id from users_role where user_id = #{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc")
    })
    public List<Role> findOtherRoles(int id)throws Exception;

    @Insert("insert into users_role values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId)throws Exception;
}
