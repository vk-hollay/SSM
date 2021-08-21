package com.hollay.controller;

import com.hollay.domain.Account;
import com.hollay.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hollay
 * @create 2021-01-25-23:06
 * @description 控制器类
 */

@Controller //加上这个注解：把这个类交给ioc容器管理，创建成对象（默认单例）
@RequestMapping(path = "/user")//path=可省略
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("Hello StringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path = "/testRequestMapping", method = {RequestMethod.GET},
            params = {"username=heihei"}, headers = {"Accept"})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解...");
        return "success";
    }

    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("执行了。。。");
        System.out.println("用户名: " + username + "  密码：" + password);
        return "success";
    }

    /**
     * 请求参数绑定到数据封装的JavaBean的类中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("执行了saveAccount");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("执行了saveUser");
        System.out.println(user);
        return "success";
    }

    /**
     * 原生的API获取
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("执行了。。。");
        System.out.println(req.getParameter("aaa"));

        HttpSession session = req.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        return "success";
    }

}
