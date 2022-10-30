package priv.noby.springmvc2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.noby.springmvc2.entity.ResponseResult;

/**
 * 全局的异常处理测试
 */
@Controller
public class GlobalExceptionTestController {
    /**
     * 全局异步异常处理测试
     */
    @ResponseBody
    @RequestMapping("/exception5.do")
    public ResponseResult<String> exception5() {
        System.out.println("UserController.exception5");
        ResponseResult<String> responseResult;
        String str = null;
        str.equals("");
        responseResult = new ResponseResult<>(200, "ok", "info");
        return responseResult;
    }
}
