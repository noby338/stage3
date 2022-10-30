package priv.noby.springsecurity3.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import priv.noby.springsecurity3.entity.ResponseResult;

/**
 * 全局异常处理
 * 不能处理认证异常处理和授权异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseResult doException(Exception ex) {
        return new ResponseResult(5000,ex.getMessage(),"自定义全局异常");
    }
}
