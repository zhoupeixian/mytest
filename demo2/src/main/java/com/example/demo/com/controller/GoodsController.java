package com.example.demo.com.controller;

import com.example.demo.com.pojo.Goods;
import com.example.demo.com.service.GoodsService;
import com.example.demo.com.util.Find;
import com.example.demo.com.util.UploadUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goodList")
    public String goodList(Integer type,Integer page, Integer length, Integer begin, Integer end, Model model, HttpSession httpSession) {
        if (page != null && length != null) {
            PageHelper.startPage(page, length);
            httpSession.setAttribute("staticPage", page);
        } else {
            PageHelper.startPage((Integer) httpSession.getAttribute("staticPage"), 4);
        }
        if (type == null) {
            type=(Integer) httpSession.getAttribute("type");
        }
        List<Goods> goods = goodsService.goodList(type);
        List<Integer> goodsIds=goodsService.topsIdList();
        for (Goods goods1:goods) {
            if (goodsIds.contains(goods1.getId())){
                goods1.setTop(true);
            }else {
                goods1.setTop(false);
            }
        }
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        model.addAttribute("pageInfo", pageInfo);
        if (type!=null){
            httpSession.setAttribute("type", type);
        }
        Find.FindCheck(pageInfo,begin,end,httpSession);
        return "jsp/good_list";
    }

    @RequestMapping("/topsDelete")
    public String topsDeleteInteger(String gid){
        goodsService.topsDelete(gid);
        return "redirect:/goodList";
    }

    @RequestMapping("/topsInsert")
    public String topsInsert(Integer tid,String gid){
        goodsService.topsInsert(tid,gid);
        return "redirect:/goodList";
    }

    @RequestMapping("/goodDelete")
    public String goodDelete(Integer id){
        goodsService.goodDelete(id);
        return "redirect:/goodList";
    }

    @RequestMapping("/goodAdd")
    public String goodAdd(Model model){
        model.addAttribute("typeList",goodsService.typeList());
        return "jsp/good_add";
    }
    @RequestMapping("/goodSave")
    public String goodSave(Goods goods,MultipartFile file, HttpServletRequest request) throws Exception {
        goods.setCover(UploadUtil.upload(file,request));
        goodsService.goodSave(goods);
        return "redirect:/goodList";
    }

    @RequestMapping("/goodEdit")
    public String goodEdit(Goods goods, Model model){
        model.addAttribute("typeList",goodsService.typeList());
        model.addAttribute("good",goods);
        return "jsp/good_edit";
    }

    @RequestMapping("/goodUpdate")
    public String goodUpdate(Goods goods,MultipartFile file,HttpServletRequest request) throws Exception{
        String cover=UploadUtil.upload(file,request);
        if (cover!=null){
            goods.setCover(cover);
        }
        goodsService.goodUpdate(goods);
        return "redirect:/goodList";
    }

}
