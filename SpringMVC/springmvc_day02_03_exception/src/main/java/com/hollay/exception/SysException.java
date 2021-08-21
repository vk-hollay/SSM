package com.hollay.exception;

/**
 * @author hollay
 * @create 2021-01-30-18:30
 * @description 自定义异常类
 */
public class SysException extends Exception {
    // 存储提示信息的
    private String massage;

    public SysException(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }


}
