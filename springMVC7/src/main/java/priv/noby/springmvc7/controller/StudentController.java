package priv.noby.springmvc7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import priv.noby.springmvc7.exception.MyException;

/**
 * 本类抛出的异常将由SpringMVC处理
 *
 * @author Noby
 * @since 2022/10/14
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     * 抛出类型转换异常
     *
     * @param modelAndView
     * @return
     */
    @GetMapping("/selectById")
    public ModelAndView selectById(ModelAndView modelAndView) {
        System.out.println("StudentController.selectById");
        Object str = "noby";
        Integer num = (Integer)str;
        modelAndView.setViewName("forward:/student.jsp");
        modelAndView.addObject("info","模拟成功返回了一条学生信息");
        return modelAndView;
    }

    /**
     * 抛出除零异常
     *
     * @param modelAndView
     * @return
     */
    @GetMapping("/selectById2")
    public ModelAndView selectById2(ModelAndView modelAndView) {
        System.out.println("StudentController.selectById2");
        int i = 1/0;
        //如果异常被处理将将不会由SpringMVC处理
//        try {
//            int i = 1/0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        modelAndView.setViewName("forward:/student.jsp");
        modelAndView.addObject("info","模拟成功返回了一条学生信息");
        return modelAndView;
    }

    /**
     * 抛出自定义异常
     *
     * @param modelAndView
     * @return
     */
    @GetMapping("/selectById3")
    public ModelAndView selectById3(ModelAndView modelAndView) {
        System.out.println("StudentController.selectById3");
        if (true) {
            throw new MyException();
        }
        modelAndView.setViewName("forward:/student.jsp");
        modelAndView.addObject("info","模拟成功返回了一条学生信息");
        return modelAndView;
    }
}

