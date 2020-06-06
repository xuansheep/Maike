package com.john.order.domain.result;

import com.john.order.domain.enums.ExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;

/**
 * @author xuhang
 * @date 2020/6/6 18:28
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public Result handleAppException(CustomException e){
        log.warn("code:{}, message:{}", e.getCode(), e.getMessage());
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(e.getCode());
        r.setMessage(e.getMessage());
        return r;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(ExceptionEnum.REQUEST_PATH_ERROR);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result parameterNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(ExceptionEnum.PARAMETER_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    public Result handleSqlException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(ExceptionEnum.DATABASE_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        log.error(e.getMessage(), e);
        return Result.error(ExceptionEnum.SYSTEM_ERROR);
    }
}
