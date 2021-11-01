package com.example.demo.com.service;

import com.example.demo.com.pojo.Admins;

import java.util.List;

/**
 * @author Administrator
 */
public interface AdminsService {

    List<Admins> login(String username, String password);

    int adminDelete(Integer id);

    int adminSave(Admins admins);

    int adminReset(Admins admins);

}
