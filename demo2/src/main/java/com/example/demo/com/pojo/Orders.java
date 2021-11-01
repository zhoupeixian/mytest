package com.example.demo.com.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Orders {
    private int id;
    private int total;
    private int amount;
    private byte status;
    private byte paytype;
    private String name;
    private String phone;
    private String address;
    private Date systime;
    private int user_id;
    private Users user;
    private List<Items> itemsList;
}
