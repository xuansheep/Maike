package com.john.order.domain.enums;

/**
 * @author xuhang
 * @date 2020/6/6 17:03
 */
public enum ExceptionEnum {

    //用户引发的错误
    PARAMETER_ERROR("A9001","参数错误"),
    REQUEST_PATH_ERROR("A9002","路径错误"),
    WEB_ERROR("A9999", "系统繁忙"),


    //业务引发的错误
    LOGIN_PASSWORD_ERROR("B0001", "用户名或密码错误"),
    SYSTEM_ERROR("B9999", "系统繁忙"),


    //数据库引发的错误
    DATABASE_ERROR("C9999", "系统繁忙");


    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
