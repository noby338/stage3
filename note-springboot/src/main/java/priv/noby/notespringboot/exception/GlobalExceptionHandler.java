package priv.noby.notespringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * 不能处理认证异常处理和授权异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity doException(Exception ex) {
//        System.out.println("GlobalExceptionHandler.doException");
//        return new ResponseResult(500,ex.getMessage(),"自定义全局异常");
        return new ResponseEntity<>(ex.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
