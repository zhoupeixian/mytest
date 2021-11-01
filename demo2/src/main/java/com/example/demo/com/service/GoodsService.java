package com.example.demo.com.service;

import com.example.demo.com.pojo.Goods;
import com.example.demo.com.pojo.Types;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {

    List<Goods> goodList(Integer type);

    List<Integer> topsIdList();

    int topsDelete(String gid);

    int topsInsert(Integer tid,String gid);

    int goodDelete(Integer id);

    List<Types> typeList();

    int goodSave(Goods goods);

    int goodUpdate(Goods goods);
}
