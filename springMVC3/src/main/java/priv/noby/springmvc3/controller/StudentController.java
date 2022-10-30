package priv.noby.springmvc3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * SpringMVC的入门使用
 *
 * @author Noby
 * @since 2022/10/11
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    /**
     * RequestMapping注解的基本使用
     *
     * 可设置响应的编码格式 produces = "application/json;charset=utf-8"
     * @return
     */
    @RequestMapping("/selectById")
    public String selectById() {
        System.out.println("StudentController.selectById");
        //redirect:重定向 forward:转发
        return "forward:/student.jsp";
    }

    /**
     * RequestMapping注解的method属性：请求必须为post请求，否则为405异常
     *
     * @return
     */
    @RequestMapping(value = "/selectById2", method = RequestMethod.POST)
    public String selectById2() {
        System.out.println("StudentController.selectById2");
        return "forward:/student.jsp";
    }

    /**
     * RequestMapping注解的params属性：请求必须携带该参数，否则400异常
     *
     * @return
     */
    @RequestMapping(value = "/selectById3", params = {"username"})
    public String selectById3() {
        System.out.println("StudentController.selectById3");
        return "forward:/student.jsp";
    }

    /**
     * 视图解析器的配置测试
     *
     * 在spring-mvc的配置文件中配置
     * @return
     */
    @RequestMapping("/otherJsp")
    public String otherJsp() {
        System.out.println("StudentController.otherJsp");
        //通过视图解析器的配置后的实际地址为 /jsp/other_jsp.jsp
        return "other_jsp";
    }
}
