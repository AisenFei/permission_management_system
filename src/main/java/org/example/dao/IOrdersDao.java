package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.example.domain.Member;
import org.example.domain.Orders;
import org.example.domain.Product;

import java.util.List;

public interface IOrdersDao {

    @Select("select * from orders")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "order_num"),
            @Result(property = "orderTime",column = "order_time"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "peopleCount",column = "people_count"),
            @Result(property = "payType",column = "pay_type"),
            @Result(property = "orderDesc",column = "order_desc"),
            @Result(property = "product",column = "product_id",one = @One(select = "org.example.dao.IProductDao.findById"))
    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{id}")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "order_num"),
            @Result(property = "orderTime",column = "order_time"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "peopleCount",column = "people_count"),
            @Result(property = "payType",column = "pay_type"),
            @Result(property = "orderDesc",column = "order_desc"),
            @Result(property = "product",column = "product_id",javaType = Product.class,one = @One(select = "org.example.dao.IProductDao.findById")),
            @Result(property = "member",column = "member_id",javaType = Member.class,one = @One(select = "org.example.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "org.example.dao.ITravellerDao.findByOrdersId"))
    })
    public Orders findById(int id);
}
