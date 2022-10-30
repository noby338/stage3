package priv.noby.vuespringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.vuespringboot.entity.ResponseResult;

import javax.servlet.http.HttpSession;


@RestController
public class UserSessionController {

    /**
     * 通过传统的 session 验证用户
     * @param username
     * @param password
     * @param session
     * @return
     */
    @GetMapping("/login")
    public ResponseResult login(String username, String password, HttpSession session) {
        System.out.println("session.getId() = " + session.getId());
        if("root".equals(username) && "123".equals(password)) {
            session.setAttribute("user", username);
            return new ResponseResult(200,"y",null);
        }
        return new ResponseResult(401,"n",null);
    }
}
