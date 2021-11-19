package com.example.demo.com.service;

import com.example.demo.com.pojo.Types;

import java.util.List;

public interface TypeService {
    List<Types> typeList();

    int typeDelete(int id);

    int toAddTypes(Types types);

    Types typeEdit(Integer id);

    int typeUpdate(Types types);

}
