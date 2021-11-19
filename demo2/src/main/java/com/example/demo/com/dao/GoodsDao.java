package com.example.demo.com.dao;

import com.example.demo.com.pojo.Goods;
import com.example.demo.com.pojo.Types;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {

    List<Goods> goodList(Integer type);

    List<Integer> topsIdList();

    int topsDelete(String gid);

    int topsInsert(@Param(value = "tid") Integer tid,@Param(value = "gid") String gid);

    int goodDelete(Integer id);

    List<Types> typeList();

    int goodSave(Goods goods);

    int goodUpdate(Goods goods);
}
