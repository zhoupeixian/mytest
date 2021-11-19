package com.example.demo.com.service.impl;

import com.example.demo.com.dao.UsersDao;
import com.example.demo.com.pojo.Users;
import com.example.demo.com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersDao usersDao;

    @Override
    public List<Users> userList() { return usersDao.userList(); }

    @Override
    public int userDelete(Integer id) { return usersDao.userDelete(id); }

    @Override
    public int userSave(Users users) { return usersDao.userSave(users); }

    @Override
    public Users userEdit(Integer id) { return usersDao.userEdit(id); }

    @Override
    public int userUpdate(Users users) { return usersDao.userUpdate(users); }

    @Override
    public int userReset(Integer id, String password1) { return usersDao.userReset(id,password1); }
}
