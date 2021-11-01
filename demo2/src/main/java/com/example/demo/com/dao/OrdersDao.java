package com.example.demo.com.dao;

import com.example.demo.com.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersDao {

    List<Orders> orderList(Integer status);
}
