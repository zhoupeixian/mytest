package com.example.demo.com.service.impl;

import com.example.demo.com.dao.OrdersDao;
import com.example.demo.com.pojo.Orders;
import com.example.demo.com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrdersService {
    @Autowired
    OrdersDao ordersDao;

    @Override
    public List<Orders> orderList(Integer status) { return ordersDao.orderList(status); }
}
