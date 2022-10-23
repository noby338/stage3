package priv.noby.note.springboot4.controller;

import org.springframework.web.bind.annotation.*;
import priv.noby.note.springboot4.entity.User;

import javax.servlet.http.HttpSession;

/**
 * 登录模拟拦截器的使用
 *
 * @author Noby
 * @since 2022/10/22
 */
@RequestMapping(value = "/student",produces = "application/json;charset=utf-8")
@RestController
public class StudentController {

    @GetMapping("/doSomethingAfterLogin")
    public String doSomethingAfterLogin(HttpSession session) {
        System.out.println("StudentController.doSomethingAfterLogin");
        User user = (User) session.getAttribute("user");
        return user.getName() + "操作成功";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        System.out.println("StudentController.login");
        if ("noby".equals(user.getName()) && "123".equals(user.getPassword())) {
            session.setAttribute("user", user);
        }
        return "登录成功";
    }
}
