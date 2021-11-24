package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.example.domain.Product;

import java.util.List;

public interface IProductDao {

    //按照id查询产品
    @Select("select * from product where id=#{id}")
    @ResultMap(value = "productMap")
    Product findById(int id) throws Exception;

    //查询所有的产品信息
    @Select("select * from product")
    @Results(id = "productMap",value = {

            @Result(id = true,property = "id",column = "id"),
            @Result(property = "productNum",column = "product_num"),
            @Result(property = "productName",column = "product_name"),
            @Result(property = "cityName",column = "city_name"),
            @Result(property = "departureTime",column = "departure_time"),
            @Result(property = "productPrice",column = "product_price"),
            @Result(property = "productDesc",column = "product_desc"),
            @Result(property = "productStatus",column = "product_status")
    })
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(product_num,product_name,city_name,departure_time,product_price,product_desc,product_status) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})" )
    public void save(Product product);
}
