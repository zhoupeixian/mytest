package com.example.demo.com.service;

import com.example.demo.com.pojo.Orders;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrdersService {

    List<Orders> orderList(Integer status);
}
