package com.john.order.domain.result;

import com.john.order.domain.enums.ExceptionEnum;
import lombok.Data;

/**
 * @author xuhang
 * @date 2020/6/6 16:49
 */
@Data
public class CustomException extends RuntimeException {

    /**
     * 响应状态码
     */
    private String code = "B9999";
    /**
     * 响应信息
     */
    private String message;

    public CustomException() {
    }

    public CustomException(ExceptionEnum ee) {
        this.code = ee.getCode();
        this.message = ee.getMessage();
    }

    public CustomException(String message) {
        super();
        this.message = message;
    }

    public CustomException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException(String message, String code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public CustomException(String message, Throwable cause, String code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public CustomException(Throwable cause, String code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }
}
