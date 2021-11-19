package com.example.demo.com.pojo;

import lombok.Data;

@Data
public class Items {
    private int id;
    private int price;
    private int amount;
    private int order_id;
    private int good_id;
    private Goods good;
}
