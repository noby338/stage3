package priv.noby.springsecurity2.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.springsecurity2.entity.ResponseResult;
import priv.noby.springsecurity2.entity.User;
import priv.noby.springsecurity2.service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    LoginService loginService;

    /**
     * 使用 jwt 验证用户登录
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user, HttpServletResponse response) {
        //登录成功，将token存入响应头
        String token = loginService.login(user);
        response.setHeader("token", token);
        response.setHeader("Access-Control-Expose-Headers", "token");
        return new ResponseResult(200, "ok", null);
    }
}
