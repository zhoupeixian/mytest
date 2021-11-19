package com.example.demo.com.controller;

import com.example.demo.com.pojo.Admins;
import com.example.demo.com.service.AdminsService;
import com.example.demo.com.util.Find;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @RequestMapping("/loginDo")
    public String loginDo(String username, String password, HttpSession httpSession){
        if (username!=null && username!="" && password!=null && password!="") {
            List<Admins> admins = adminsService.login(username, password);
            if (admins != null && admins.size()!=0) {
                httpSession.setAttribute("msg","欢迎登录!");
                httpSession.setAttribute("admins",admins.get(0));
                return "redirect:/index.jsp";
            } else {
                httpSession.setAttribute("msg", "账号或密码错误！");
                return "redirect:/login.jsp";
            }
        }else {
            httpSession.setAttribute("msg","账号或密码不能为空！");
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/adminList")
    public String adminList(Integer page, Integer length, Integer begin, Integer end, Model model, HttpSession httpSession) {
        if (page !=null && length!=null){
            PageHelper.startPage(page, length);
            httpSession.setAttribute("staticPage", page);
        }else {
            PageHelper.startPage((Integer) httpSession.getAttribute("staticPage"), 4);
        }
        List<Admins> admin = adminsService.login(null,null);
        PageInfo<Admins> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        Find.FindCheck(pageInfo,begin,end,httpSession);
        return "jsp/admin_list";
    }

    @RequestMapping("/adminDelete")
    public String adminDelete(Integer id){
        adminsService.adminDelete(id);
        return "redirect:/adminList";
    }

    @RequestMapping("/admin_add")
    public String admin_add(){ return "jsp/admin_add"; }
    @RequestMapping("/adminSave")
    public String adminSave(Admins admins){
        adminsService.adminSave(admins);
        return "redirect:/adminList";
    }

    @RequestMapping("/admin_reset")
    public String admin_reset(Admins admin,Model model){
        model.addAttribute("admin",admin);
        return "jsp/admin_reset";
    }

    @RequestMapping("/adminReset")
    public String adminReset(Admins admin){
        adminsService.adminReset(admin);
        return "redirect:/adminList";
    }
}
