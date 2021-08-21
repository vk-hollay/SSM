package com.hollay.controller;

import com.hollay.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hollay
 * @create 2021-01-30-15:55
 * @description
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行了。。。");

        try {
            //模拟异常
            int i = 1 / 0;
        } catch (Exception e) {
            //控制台打印异常信息
            e.printStackTrace();
            //向上抛出自定义异常信息
            throw new SysException("出现错误。。。");
        }

        return "success";
    }
}

