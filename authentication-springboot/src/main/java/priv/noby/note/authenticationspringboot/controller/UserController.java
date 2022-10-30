package priv.noby.note.authenticationspringboot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.note.authenticationspringboot.entity.User;
import priv.noby.note.authenticationspringboot.util.JwtUtil;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Noby
 * @since 2022/10/28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/showSessionId")
    public String showSessionId(HttpSession session) {
        System.out.println("UserController.showSessionId");
        String id = session.getId();
        System.out.println("id = " + id);
        return id;
    }


    @RequestMapping("/sessionLogin")
    public String sessionLogin(@RequestBody User user, HttpSession session) {
        System.out.println("UserController.sessionLogin");
        if ("noby".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            session.setAttribute("user",user.getUsername());
            return "sessionLogin successful";
        } else{
            System.out.println("user.getUsername() = " + user.getUsername());
            return "sessionLogin error";
        }
    }

    @RequestMapping("/jwtLogin")
    public String jwtLogin(@RequestBody User user, HttpServletResponse response) {
        System.out.println("UserController.jwtLogin");
        if("noby".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            String token = JwtUtil.create(user.getUsername());
            response.setHeader("token", token);
            //在写入token响应头时，必须同时响应以下头，该响应头作用是使浏览器具有存储该响应头到本地的权限，否则前端无法在浏览器存入token的值
            response.setHeader("Access-Control-Expose-Headers", "token");
            return "jwtLogin successful";
        }else{
            return "jwtLogin error";
        }
    }
}
