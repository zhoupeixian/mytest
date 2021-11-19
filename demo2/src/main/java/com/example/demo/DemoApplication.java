package com.example.demo;

import com.example.demo.com.Component.CustInterceptor;
import com.example.demo.com.Component.LoginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.annotation.Resource;

/**
 * @program: file
 * @description: (webconfig 视图层自定义配置)
 * @author: kikock
 * @create: 2018-11-15 09:26
 **/
@Configuration
@EnableWebMvc
@SpringBootApplication(exclude={SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class})
public class DemoApplication implements WebMvcConfigurer {

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }

    @Resource
    CustInterceptor custInterceptor;
    @Resource
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(custInterceptor).addPathPatterns("/**").excludePathPatterns("/test","/loginDo");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/test");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry){
        viewControllerRegistry.addViewController("/test").setViewName("redirect:/login.jsp");
    }

    /**
     * @Description: 注册jsp视图解析器
     * @params: []
     * @return: org.springframework.web.servlet.ViewResolver
     * @author kikock
     * @date 2018/11/15 9:28
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //配置放置jsp文件夹
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        //重要 setViewNames 通过它识别为jsp页面引擎
        resolver.setViewNames("jsp/*");
        resolver.setOrder(2);
        return resolver;
    }
    /**
     * @Description: 注册html视图解析器
     * @params: []
     * @return: org.thymeleaf.templateresolver.ITemplateResolver
     * @author kikock
     * @date 2018/11/15 9:30
     */
    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setTemplateMode("HTML");
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("utf-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    /**
     * @Description: 将自定义tml视图解析器添加到模板引擎并主持到ioc
     * @params: []
     * @return: org.thymeleaf.spring5.SpringTemplateEngine
     * @author kikock
     * @date 2018/11/15 9:32
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").addResourceLocations("file:///Users/Administrator/Desktop/demo2/src/main/resources/static/");
        //此处还可继续增加目录。。。。
    }

}
