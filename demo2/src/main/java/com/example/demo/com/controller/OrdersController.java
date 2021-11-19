package com.example.demo.com.controller;

import com.example.demo.com.pojo.Orders;
import com.example.demo.com.service.OrdersService;
import com.example.demo.com.util.Find;
import com.example.demo.com.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @RequestMapping("/orderList")
    public String orderList(Integer page, Integer length, Integer begin, Integer end,Integer status, Model model, HttpSession httpSession){
        if (status==null){
            System.out.println(httpSession.getAttribute("status"));
            status=(Integer) httpSession.getAttribute("status");
        }
        List<Orders> orders = ordersService.orderList(status);
        List<Orders> orders1=Page.startPage(orders,page,length);
        PageInfo<Orders> pageInfo = new PageInfo<>(orders1);
        pageInfo.setTotal(orders.size());
        int size=orders.size();
        if (size%length!=0) {
            pageInfo.setPages(size/length + 1);
        }else {
            pageInfo.setPages(size/length);
        }
        pageInfo.setPageNum(page);
        model.addAttribute("pageInfo",pageInfo);
        if (status!=null) {
            httpSession.setAttribute("status", status);
        }
        Find.FindCheck(pageInfo,begin,end,httpSession);
        return "jsp/order_list";
    }
}
