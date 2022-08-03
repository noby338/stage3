package priv.noby.vuespringboot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import priv.noby.vuespringboot.entity.ResponseResult;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseResult doException(Exception ex) {
        System.out.println("GlobalExceptionHandler.doException");
        return new ResponseResult(401,ex.getMessage(),null);
    }
}
