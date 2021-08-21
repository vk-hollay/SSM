package com.hollay13.mybatis.cfg;

/**
 * @author hollay
 * @create 2021-02-01-18:47
 * @description 用于封装执行的 SQL语句和结果集类型的全限定类名
 */
public class Mapper {

    private String queryString;//SQL
    private String resultType;//实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
