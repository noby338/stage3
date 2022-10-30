package priv.noby.springmvc6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Noby
 * @since 2022/10/14
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/selectById/{id}")
    public ModelAndView selectById(@PathVariable("id") int id, ModelAndView modelAndView) {
        System.out.println("StudentController.selectById");
        modelAndView.setViewName("forward:/student.jsp");
        modelAndView.addObject("info","模拟成功返回了一条学生信息：id = " + id);
        return modelAndView;
    }
}
