package com.example.demo.com.service.impl;

import com.example.demo.com.dao.GoodsDao;
import com.example.demo.com.pojo.Goods;
import com.example.demo.com.pojo.Types;
import com.example.demo.com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> goodList(Integer type) { return goodsDao.goodList(type); }

    @Override
    public List<Integer> topsIdList() { return goodsDao.topsIdList(); }

    @Override
    public int topsDelete(String gid) { return goodsDao.topsDelete(gid); }

    @Override
    public int topsInsert(Integer tid, String gid) { return goodsDao.topsInsert(tid,gid); }

    @Override
    public int goodDelete(Integer id) { return goodsDao.goodDelete(id); }

    @Override
    public List<Types> typeList() { return goodsDao.typeList(); }

    @Override
    public int goodSave(Goods goods) { return goodsDao.goodSave(goods); }

    @Override
    public int goodUpdate(Goods goods) { return goodsDao.goodUpdate(goods); }
}
