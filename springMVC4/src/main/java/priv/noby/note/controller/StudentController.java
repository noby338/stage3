package priv.noby.note.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import priv.noby.note.entity.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SpringMVC数据的响应方式
 *
 * 1） 页面跳转
 *  直接返回字符串
 *  通过ModelAndView对象返回
 * 2） 回写数据
 *  直接返回字符串
 *  返回对象或集合
 * @author Noby
 * @since 2022/10/11
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    /**
     * 页面跳转，直接返回字符串
     *
     * 此种方式会将返回的字符串与视图解析器的前后缀拼接后跳转。
     * @return
     */
    @RequestMapping("/selectById")
    public String selectById() {
        System.out.println("StudentController.selectById");
        //redirect:重定向 forward:转发 默认书写路径为转发
        return "forward:/student.jsp";
//        return "/student.jsp";
//        return "redirect:/student.jsp";
    }

    /**
     * 页面跳转，通过ModelAndView对象返回，ModelAndView对象为方法内部实例化
     *
     * model用于封装数据
     * view用于展示数据
     * @return
     */
    @RequestMapping("/selectById2")
    public ModelAndView selectById2() {
        System.out.println("StudentController.selectById2");
        ModelAndView modelAndView = new ModelAndView();
        //设置视图
        modelAndView.setViewName("forward:/student.jsp");
        //设置数据
        modelAndView.addObject("info","selectById2Info");
        return modelAndView;
    }

    /**
     * 页面跳转，通过ModelAndView对象返回，ModelAndView对象为方法参数列表封装
     *
     * model用于封装数据
     * view用于展示数据
     * @return
     */
    @RequestMapping("/selectById21")
    public ModelAndView selectById21(ModelAndView modelAndView) {
        /*
        Controller中的方法都是SpringMVC调用，当调用selectById21()方法时可识别其中需要的参数，
        参数列表中的ModelAndView对象实际上是SpringMVC调用selectById21()方法时，自动注入的并传入方法的对象
         */
        System.out.println("StudentController.selectById21");
        //设置视图
        modelAndView.setViewName("forward:/student.jsp");
        //设置数据
        modelAndView.addObject("info","selectById21Info");
        return modelAndView;
    }


    /**
     * 页面跳转，通过ModelAndView对象返回，Model对象和返回字符串表示视图组合
     *
     * model用于封装数据
     * view用于展示数据
     * @return
     */
    @RequestMapping("/selectById22")
    public String selectById22(Model model) {
        /*
        参数列表中的Model对象实际上是SpringMVC自动注入的对象
         */
        System.out.println("StudentController.selectById22");
        //设置数据
        model.addAttribute("info","selectById22Info");
        return "forward:/student.jsp";
    }

    /**
     * 页面跳转，通过ModelAndView对象返回，HttpServletRequest对象和返回字符串表示视图组合
     *
     * model用于封装数据
     * view用于展示数据
     * @return
     */
    @RequestMapping("/selectById23")
    public String selectById23(HttpServletRequest request) {
        /*
        参数列表中的Model对象实际上是SpringMVC自动注入的对象
         */
        System.out.println("StudentController.selectById23");
        //设置数据
        request.setAttribute("info","selectById23Info");
        return "forward:/student.jsp";
    }

    /**
     * 回写数据，直接返回字符串
     *
     * 使用@ResponseBody注解
     * @return
     */
    @RequestMapping("/selectById3")
    //告知SpringMVC框架，返回的字符串不进行视图跳转，直接进行数据响应
    @ResponseBody
    public String selectById3() {
        System.out.println("StudentController.selectById3");
        return "@ResponseBody注解 数据响应 selectById3";
    }

    /**
     * 回写数据，直接返回字符串
     *
     * 使用Response对象
     * @return
     */
    @RequestMapping("/selectById31")
    public void selectById31(HttpServletResponse response) throws IOException {
        System.out.println("StudentController.selectById31");
        response.getWriter().write("HttpServletResponse 数据响应 selectById31");
    }

    /**
     * 回写数据，直接返回字符串
     *
     * 使用@ResponseBody注解利用第三方工具返回自定义json格式字符串
     * @return
     */
    @RequestMapping("/selectById32")
    //告知SpringMVC框架，返回的字符串不进行视图跳转，直接进行数据响应
    @ResponseBody
    public String selectById32() {
        System.out.println("StudentController.selectById32");
        Student student = new Student();
        student.setName("noby");
        student.setAge(20);
        ObjectMapper objectMapper = new ObjectMapper();
        String studentJson = null;
        try {
            studentJson = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return studentJson;
    }

    /**
     * 回写数据，返回对象或集合
     *
     * Spring-mvc.xml配置处理器映射器(有普通配置和mvc注解驱动两种方式)，处理器映射器可直接将将要返回的对象转换为json
     * @return
     */
    @RequestMapping("/selectById4")
    @ResponseBody
    public Student selectById4() {
        System.out.println("StudentController.selectById4");
        //redirect:重定向 forward:转发
        Student student = new Student();
        student.setName("noby");
        student.setAge(20);
        return student;
    }

}
