package com.example.demo.com.pojo;

import lombok.Data;

@Data
public class Goods {
    private int id;
    private String cover;
    private String name;
    private String intro;
    private String spec;
    private int price;
    private int stock;
    private int sales;
    private String content;
    private int type_id;
    private boolean top;
    private String typename;
}
