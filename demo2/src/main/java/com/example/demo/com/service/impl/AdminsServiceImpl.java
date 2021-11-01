package com.example.demo.com.service.impl;

import com.example.demo.com.dao.AdminsDao;
import com.example.demo.com.pojo.Admins;
import com.example.demo.com.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsDao adminsDao;

    @Override
    public List<Admins> login(String username, String password) { return adminsDao.login(username,password); }

    @Override
    public int adminDelete(Integer id) { return adminsDao.adminDelete(id); }

    @Override
    public int adminSave(Admins admins) { return adminsDao.adminSave(admins); }

    @Override
    public int adminReset(Admins admins) { return adminsDao.adminReset(admins); }
}
