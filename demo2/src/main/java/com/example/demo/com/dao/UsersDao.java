package com.example.demo.com.dao;

import com.example.demo.com.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersDao {

    List<Users> userList();

    int userDelete(Integer id);

    int userSave(Users users);

    Users userEdit(Integer id);

    int userUpdate(Users users);

    int userReset(@Param(value = "id")Integer id,@Param(value = "password1")String password1);
}
