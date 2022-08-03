package priv.noby.note.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.noby.note.entity.ResponseResult;

/**
 * 配置全局异常处理（可在所有controller中处理）
 */
@ControllerAdvice//该注解中包含了@responseBody，可在方法中省略书写
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
