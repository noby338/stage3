package priv.noby.springboot4.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.noby.springboot4.entity.ResponseResult;

/**
 * 配置全局异常处理（可在所有controller中处理）
 */
//全局异常处理：结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常。
@ControllerAdvice
//该注解在@ControllerAdvice的基础上中包含了@responseBody，可在方法中省略书写
//@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 配置处理异步请求
     */
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ResponseResult<Exception> doExceptionHandler(Exception e){
        System.out.println("ExceptionHandlerController.doExceptionHandler");
        return new ResponseResult<>(500, "MyNullPointerException", e);
    }

    /**
     * 配置处理同步请求
     */
//    @ExceptionHandler(NullPointerException.class)
//    public String doExceptionHandler(Exception e){
//        System.out.println("ExceptionHandlerController.doExceptionHandler");
//        return "forward:/nullpointert_exception.html";
//    }
}
