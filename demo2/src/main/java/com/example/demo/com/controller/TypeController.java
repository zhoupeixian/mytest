package com.example.demo.com.controller;

import com.example.demo.com.pojo.Types;
import com.example.demo.com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/typeList")
    public String typeList(Model model) {
        List<Types> types=typeService.typeList();
        model.addAttribute("types",types);
        return "jsp/type_list";
    }

    @RequestMapping("/typeDelete")
    public String typeDelete(Integer id) {
        typeService.typeDelete(id);
        return "redirect:/typeList";
    }

    @RequestMapping("/type_add")
    public String type_add() {
        return "jsp/type_add";
    }
    @RequestMapping("/toAddTypes")
    public String toAddTypes(Types types) {
        typeService.toAddTypes(types);
        return "redirect:/typeList";
    }

    @RequestMapping("/typeEdit")
    public String typeEdit(Integer id,Model model) {
        Types type= typeService.typeEdit(id);
        model.addAttribute("type",type);
        return "jsp/type_edit";
    }

    @RequestMapping("/typeUpdate")
    public String typeUpdate(Types types) {
        typeService.typeUpdate(types);
        System.out.println(1);
        return "redirect:/typeList";
    }
}
