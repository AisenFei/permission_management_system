package org.example.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Traveller;

import java.util.List;

public interface ITravellerDao {
    @Select("select * from traveller where id in (select traveller_id from order_traveller where order_id = #{orders_id})")
    @Results(id = "findByOrdersId",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "phoneNum",column = "phone_num"),
            @Result(property = "credentialsType",column = "credentials_Type"),
            @Result(property = "credentialsNum",column = "credentials_num"),
            @Result(property = "travellerType",column = "traveller_type")
    })
    public List<Traveller> findByOrdersId(int orders_id) throws Exception;
}
