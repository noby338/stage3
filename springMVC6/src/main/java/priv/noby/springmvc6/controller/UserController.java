package priv.noby.springmvc6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Noby
 * @since 2022/10/14
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public ModelAndView login(String username, String password, ModelAndView modelAndView, HttpSession session) {
        if ("noby".equals(username) && "123".equals(password)) {
            session.setAttribute("user", "user");
            modelAndView.setViewName("forward:/student.jsp");
        } else {
            modelAndView.setViewName("forward:/login.jsp");
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {
        session.removeAttribute("user");
        modelAndView.setViewName("forward:/login.jsp");
        return modelAndView;
    }
}
