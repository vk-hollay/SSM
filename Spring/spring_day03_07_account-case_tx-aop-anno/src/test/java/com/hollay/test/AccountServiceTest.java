package com.hollay.test;

import com.hollay.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author hollay
 * @create 2021-01-19-16:58
 * @description 使用Junit单元测试，测试我们的配置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class AccountServiceTest {

    @Autowired
    private AccountService as;

    @Test
    public void testTransfer() {
        as.transfer("bbb", "ccc",200f);
    }
}
