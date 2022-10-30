package priv.noby.springmvc2.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import priv.noby.springmvc2.entity.ResponseResult;

/**
 * 配置全局异常处理（可在所有controller中处理）
 */
//全局异常处理：结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常。
@ControllerAdvice
//该注解在@ControllerAdvice的基础上中包含了@responseBody，可在方法中省略书写
@RestControllerAdvice
public class ExceptionHandlerController {
    /**
     * 配置处理异步请求
     */
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ResponseResult<String> doExceptionHandler(Exception e){
        System.out.println("ExceptionHandlerController.doExceptionHandler");
        return new ResponseResult<String>(500, "error", null);
    }
}
