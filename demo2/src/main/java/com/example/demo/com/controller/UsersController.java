package com.example.demo.com.controller;

import com.example.demo.com.pojo.Users;
import com.example.demo.com.service.UsersService;
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
public class UsersController {
    @Autowired
    UsersService usersService;

    @RequestMapping("/userList")
    public String userList(Integer page, Integer length, Integer begin, Integer end, Model model, HttpSession httpSession) {
        if (page !=null && length!=null){
            PageHelper.startPage(page, length);
            httpSession.setAttribute("staticPage", page);
        }else {
            PageHelper.startPage((Integer) httpSession.getAttribute("staticPage"), 4);
        }
        List<Users> users = usersService.userList();
        PageInfo<Users> pageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo",pageInfo);
        Find.FindCheck(pageInfo,begin,end,httpSession);
        return "jsp/user_list";
    }

    @RequestMapping("/userDelete")
    public String userDelete(Integer id) {
        usersService.userDelete(id);
        return "redirect:/userList";
    }

    @RequestMapping("/user_add")
    public String user_add() { return "jsp/user_add"; }
    @RequestMapping("/userSave")
    public String userSave(Users users) {
        usersService.userSave(users);
        return "redirect:/userList";
    }

    @RequestMapping("/userEdit")
    public String userEdit(Integer id,Model model) {
        Users user=usersService.userEdit(id);
        model.addAttribute("user",user);
        return "jsp/user_edit";
    }

    @RequestMapping("/userUpdate")
    public String userUpdate(Users users) {
        usersService.userUpdate(users);
        return "redirect:/userList";
    }

    @RequestMapping("/user_reset")
    public String user_reset(Integer id,String username,String password,Model model) {
        model.addAttribute("id",id);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "jsp/user_reset";
    }

    @RequestMapping("/userReset")
    public String userReset(Integer id,String password,String password1) {
        usersService.userReset(id,password1);
        return "redirect:/userList";
    }

}
