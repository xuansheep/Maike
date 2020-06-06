package com.john.order.domain.result;

import com.john.order.domain.enums.ExceptionEnum;
import lombok.Data;

/**
 * @author xuhang
 * @date 2020/6/6 18:00
 */
@Data
public class Result {

    private static final String REQUEST_SUCCESS_CODE = "00000";
    private static final String REQUEST_ERROR_CODE = "B9999";
    private static final String REQUEST_SUCCESS_MESSAGE = "请求成功";
    private static final String REQUEST_ERROR_MESSAGE = "系统繁忙";

    private String code;

    private Boolean success;

    private String message;

    private Object data;

    public Result(){
        this.code = REQUEST_SUCCESS_CODE;
        this.success = true;
        this.message = REQUEST_SUCCESS_MESSAGE;
    }

    public Result(Boolean success, String code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(){
        return new Result();
    }

    public static Result success(Boolean success){
        Result result = new Result();
        result.success = success;
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.data = data;
        return result;
    }

    public static Result error(String code, String message){
        Result result = new Result();
        result.code = code;
        result.message = message;
        result.success = false;
        result.data = new Object();
        return result;
    }

    public static Result error(ExceptionEnum e) {
        return new Result(false, e.getCode(), e.getMessage(), null);
    }
}
