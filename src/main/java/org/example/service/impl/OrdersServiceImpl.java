package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import org.example.dao.IOrdersDao;
import org.example.domain.Orders;
import org.example.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception{
        //pageNum 表示的是从第几页开始，pageSize表示的是每页是几条数据
        PageHelper.startPage(page,size);
        return iOrdersDao.findAll();
    }

    @Override
    public Orders findById(int id) throws Exception {
        return iOrdersDao.findById(id);
    }


}
