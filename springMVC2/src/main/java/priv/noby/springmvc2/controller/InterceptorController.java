package priv.noby.springmvc2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.noby.springmvc2.entity.ResponseResult;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    /**
     * 拦截器测试
     * 拦截器只拦截请求，不拦截静态资源
     */
    @ResponseBody
    @RequestMapping("/interceptorTest.do")
    public ResponseResult<String> interceptorTest() {
        System.out.println("UserController.interceptorTest");
        ResponseResult<String> responseResult;
        responseResult = new ResponseResult<>(200, "ok", "info");
        return responseResult;
    }
}
