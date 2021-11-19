package com.example.demo.com.service;

import com.example.demo.com.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface UsersService {
    List<Users> userList();

    int userDelete(Integer id);

    int userSave(Users users);

    Users userEdit(Integer id);

    int userUpdate(Users users);

    int userReset(Integer id,String password1);

}
