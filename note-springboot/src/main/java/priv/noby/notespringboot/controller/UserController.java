package priv.noby.notespringboot.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.notespringboot.entity.User;
import priv.noby.notespringboot.service.LoginService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    LoginService loginService;

    /**
     * 使用 jwt 验证用户登录
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        //登录成功，将token存入响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",loginService.login(user));
        headers.add("Access-Control-Expose-Headers","token");
        return new ResponseEntity<>(null,headers , HttpStatus.OK);
    }
}
