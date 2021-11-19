package com.example.demo.com.Component;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@Component
public class CustInterceptor implements HandlerInterceptor {

    /**
     * 请求处理前调用
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
        boolean needLogin =needLogin(request);
        if (!needLogin){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");
        return false;
    }

    /**
     * 请求处理后视图加载器前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView){
        System.out.println(request.getRequestURI()+"   "+System.currentTimeMillis());
    }


    private static boolean needLogin(HttpServletRequest request){
        Object admins=request.getSession().getAttribute("admins");
        if (admins!=null){
            return false;
        }
        return true;
    }
}
