package org.example.service;

import org.example.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(int id) throws Exception;
}
