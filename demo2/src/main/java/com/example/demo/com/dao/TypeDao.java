package com.example.demo.com.dao;

import com.example.demo.com.pojo.Types;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface TypeDao {
    List<Types> typeList();

    int typeDelete(int id);

    int toAddTypes(Types types);

    Types typeEdit(Integer id);

    int typeUpdate(Types types);
}
