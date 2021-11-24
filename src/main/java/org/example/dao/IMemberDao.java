package org.example.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Member;

public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    @Results(id = "memberFindById",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "phoneNum",column = "phone_num"),
            @Result(property = "email",column = "email")
    })
    Member findById(int id) throws Exception;
}
