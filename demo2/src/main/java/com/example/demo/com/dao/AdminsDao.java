package com.example.demo.com.dao;

import com.example.demo.com.pojo.Admins;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface AdminsDao {

    List<Admins> login(@Param(value = "username") String username, @Param(value = "password") String password);

    int adminDelete(Integer id);

    int adminSave(Admins admins);

    int adminReset(Admins admins);
}
