package com.example.demo.com.service.impl;

import com.example.demo.com.dao.TypeDao;
import com.example.demo.com.pojo.Types;
import com.example.demo.com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeDao typeDao;

    @Override
    public List<Types> typeList() { return typeDao.typeList(); }

    @Override
    public int typeDelete(int id) { return typeDao.typeDelete(id); }

    @Override
    public int toAddTypes(Types types) { return typeDao.toAddTypes(types); }

    @Override
    public Types typeEdit(Integer id) { return typeDao.typeEdit(id); }

    @Override
    public int typeUpdate(Types types) { return typeDao.typeUpdate(types); }
}
