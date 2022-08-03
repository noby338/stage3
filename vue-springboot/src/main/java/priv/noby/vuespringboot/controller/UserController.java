package priv.noby.vuespringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.vuespringboot.entity.ResponseResult;
import priv.noby.vuespringboot.util.JwtUtil;

import javax.servlet.http.HttpServletResponse;


@RestController
public class UserController {
    /**
     * 使用 jwt 验证用户登录
     */
    @GetMapping("/login")
    public ResponseResult login(String username, String password, HttpServletResponse response) {
        if("root".equals(username) && "123".equals(password)) {
            String token = JwtUtil.create(username);
            response.setHeader("token", token);
            //前后端分离程序，必须给前端暴露响应头，否则前端无法获取
            response.setHeader("Access-Control-Expose-Headers", "token");
            return new ResponseResult(200,"y",null);
        }
        return new ResponseResult(401,"n",null);
    }

    /**
     * 通过传统的 session 验证用户
     * @param username
     * @param password
     * @param session
     * @return
     */
//    @GetMapping("/login")
//    public ResponseResult login(String username, String password, HttpSession session) {
//        System.out.println("session.getId() = " + session.getId());
//        if("root".equals(username) && "123".equals(password)) {
//            session.setAttribute("user", username);
//            return new ResponseResult(200,"y",null);
//        }
//        return new ResponseResult(401,"n",null);
//    }
}
