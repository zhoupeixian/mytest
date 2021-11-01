package com.example.demo.com.util;

import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 */
public class Find {
    public static void FindCheck(PageInfo pageInfo,Integer begin, Integer end, HttpSession httpSession){
        if (begin==null || end==null) {
            begin=(Integer) httpSession.getAttribute("begin");
            end=(Integer) httpSession.getAttribute("end");
        }
        httpSession.setAttribute("begin", begin);
        if (end%4==0) {
            if (pageInfo.getPages() < end) {
                httpSession.setAttribute("end", pageInfo.getPages());
            } else {
                httpSession.setAttribute("end", end);

            }
        }else {
            httpSession.setAttribute("end", pageInfo.getPages());
        }
    }
}
