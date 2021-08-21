package com.hollay.controller;

import com.hollay.domain.User;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hollay
 * @create 2021-01-28-15:41
 * @description
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回 String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString方法执行了。。。");
        // 模拟从数据库中查询出 User对象
        User user = new User();
        user.setUsername("嘿嘿");
        user.setAge(20);
        user.setPassword("1234");
        //model对象存数据
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回 void
     * 请求转发是一次请求，不用编写项目的名称
     * 请求重定向是两次请求，则需要写项目名称
     * @return
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了。。。");

        // 编写请求转发的程序，手动写转发或重定向，程序不走配置的视图解析器
        //请求转发能进 WEB-INF
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //请求重定向不能进 WEB-INF
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //直接响应数据
        //解决中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("哈哈哈hello");
    }


    /**
     * 返回 ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        // 创建 ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("testModelAndView方法执行了。。。");
        // 模拟从数据库中查询出 User对象
        User user = new User();
        user.setUsername("呵呵呵");
        user.setAge(20);
        user.setPassword("2224");

        //把 user对象存储到 modelAndView对象中，也会把 user对象存入 request对象
        modelAndView.addObject("user", user);

        //跳转到那个页面
        modelAndView.setViewName("success");

        return modelAndView;
    }

    /**
     * 使用关键字的方式进行转发或者重定向（不在使用视图解析器）
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect方法执行了。。。");

        // 请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";

        // 重定向 (这里路径不用加项目名称，框架底层已帮你实现)
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     * @param user
     */
    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行了。。。");
        // 客户端发送 ajax请求，传的是 json字符串，后端把 json字符串封装到 user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }

}
