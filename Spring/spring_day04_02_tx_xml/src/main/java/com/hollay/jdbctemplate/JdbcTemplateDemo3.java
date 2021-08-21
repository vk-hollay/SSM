package com.hollay.jdbctemplate;

import com.hollay.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hollay
 * @create 2021-01-22-22:27
 * @description jdbc的CRUD操作
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        //1.获取对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert into account(name, money) values(?,?)", "eee", 9999);

        //更新
//        jt.update("update account set name=?,money=? where id=?","test",4567,11);

        //删除
//        jt.update("delete from account where id=?",12);

        //查询所有
//        List<Account> accounts = jt.query("select * from account where money>?", new AccountRowMapper(), "1000f");
        List<Account> accounts = jt.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class), "1000f");
     /*   for (Account account: accounts) {
            System.out.println(account);
        }*/
        //查询一个
        System.out.println(accounts.isEmpty() ? "没有内容" : accounts.get(0));

         //查询返回一行一列（使用聚合函数，但不加group by子句）
        Long count = jt.queryForObject("select count(*) from account where money > ?",Long.class,1000f);
        System.out.println(count);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}