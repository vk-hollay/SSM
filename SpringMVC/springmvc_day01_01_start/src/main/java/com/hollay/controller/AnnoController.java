package com.hollay.controller;

import com.hollay.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * @author hollay
 * @create 2021-01-28-0:15
 * @description 常用的注解
 */

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"} ) //把 msg=哈哈哈存入到 session域中
public class AnnoController {

    /**
     * 当变量名不对应时获取单个参数内容 @RequestParam注解
     * @param name
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="username") String name) {
        System.out.println("执行了。。。");
        System.out.println(name);
        return "success";
    }

    /**
     * 获取请求体的内容 @RequestBody注解
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了。。。");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id) {
        System.out.println("执行了。。。");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值 @RequestHeader注解
     * @param header
     * @return
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept") String header) {
        System.out.println("执行了。。。");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取cookie的值 @CookieValue注解
     * @param cookieValue
     * @return
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value="JSESSIONID") String cookieValue) {
        System.out.println("执行了。。。");
        System.out.println(cookieValue);
        return "success";
    }


    /**
     * 注解 @ModelAttribute（放方法上是该方法优先执行），写法一
     * @return
     */
    @RequestMapping(value = "/testModelAttribute1")
    public String testModelAttribute1(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute1执行了。。。");
        System.out.println(user);
        return "success";
    }

    // 该方法会先执行，无返回值
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map){
        System.out.println("showUser执行了。。。");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * 注解 @ModelAttribute（放方法上是该方法优先执行），写法二
     * @return

    @RequestMapping(value = "/testModelAttribute2")
    public String testModelAttribute2(User user) {
        System.out.println("testModelAttribute2执行了。。。");
        System.out.println(user);
        return "success";
    }

    //该方法会先执行，有返回值
    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了。。。");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
     */

    /**
     * 注解 @SessionAttributes 放在类上
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes执行了。。。");
        //底层会存储到request域对象中
        model.addAttribute("msg", "哈哈哈");
        return "success";
    }

    /**
     * 从session域中获取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("testSessionAttributes执行了。。。");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 删除session
     * @param status
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("delSessionAttributes执行了。。。");
        status.setComplete();
        return "success";
    }

}
