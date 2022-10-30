package priv.noby.springmvc2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import priv.noby.springmvc2.entity.Emp;
import priv.noby.springmvc2.entity.ResponseResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * 使用注解配置 Controller
 * 接收参数
 */
@Controller
@RequestMapping("/conNote")
public class ConNoteController {
    /**
     * springMVC 的基本使用，进入到 controller
     */
    @RequestMapping("/controller.do")
    @ResponseBody
    public void controller() {
        System.out.println("ConNoteController.controller");
    }

    /**
     * 设置服务器仅仅处理 get 请求
     */
    @RequestMapping(value = "/onlyGet.do", method = RequestMethod.GET)
//    @PostMapping("/onlyGet.do")//同上
    @ResponseBody
    public void onlyGet() {
        System.out.println("ConNoteController.onlyGet");
    }


    /**
     * 路径加通配符
     * /*表示一层
     * /**表示任意层次数
     */
    @RequestMapping("/*/character.do")
    @ResponseBody
    public void character() {
        System.out.println("ConNoteController.character");
    }

    /**
     * 接收参数
     * 基本数据类型直接方法列表声明
     * 当请求参数和参数列表不同时使用 @RequestParam 注解
     */
    @RequestMapping("/parameter.do")
    @ResponseBody
    public void parameter(String username, int age
            , @RequestParam("password") String code) {
        System.out.println("ConNoteController.parameter");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("code = " + code);
    }

    /**
     * 获取对象参数
     * 自动将键值对封装成为对象（该请求为非json的请求）
     */
    @RequestMapping("/parameterObj.do")
    @ResponseBody
    public void parameterObj(Emp emp) {
        System.out.println("ConNoteController.parameterObj");
        System.out.println("emp = " + emp);
    }

    /**
     * 获取数组参数
     * 自动将多个相同的参数名封装为一个数组
     */
    @RequestMapping("/parameterArray.do")
    @ResponseBody
    public void parameterArray(int[] ids) {
        System.out.println("ConNoteController.parameterArray");
        System.out.println("Arrays.toString(ids) = " + Arrays.toString(ids));
    }

    /**
     * 处理请求乱码
     * tomcat8 及以后没有 get 乱码
     * tomcat7 get 乱码处理一般在 pom Maven 的插件中指定
     * post 乱码处理方式为在 web.xml 中配置
     */
    @RequestMapping("/encoding.do")
    @ResponseBody
    public void encoding(String info) {
        System.out.println("ConNoteController.encoding");
        System.out.println("info = " + info);
    }

    /**
     * 页面跳转方式1
     */
    @RequestMapping("/forward.do")
    public ModelAndView forward() {
        ModelAndView modelAndView = new ModelAndView("/forward.jsp");
        return modelAndView;
    }

    /**
     * 页面跳转方式2(该方式也可用于重定向)
     * 通过 model 在 request 与中存入属性
     */
    @RequestMapping("/forward2.do")
    public String forward2(Model model) {
        System.out.println("ConNoteController.forward2");
        model.addAttribute("info", "information");
        //使用Model做参数，String做返回值，和 ModelAndView 做返回值一样
        return "/forward.jsp";
//        return "redirect:/forward.jsp";//此处的浏览器路径以被Spring优化
    }

    /**
     * 处理异步请求
     *
     * @ResponseBody 的作用是将返回的对象转换为json字符串
     * 该注解的使用注意在SpringMVC的配置文件中配置注解驱动
     * 注意导入jackson的坐标（SpringMVC的json和对象的转换底层使用的是该jar）
     */
    @ResponseBody
    @RequestMapping("/asynchronous.do")
    public Emp asynchronous() {
        System.out.println("ConNoteController.asynchronous");
        Emp emp = new Emp(200, "noby", null);
        System.out.println("emp = " + emp);
        return emp;
    }

    /**
     * 传统方法jackson处理异步请求
     * 响应的是一个对象而非json
     */
    @RequestMapping("/asynchronous2.do")
    public void asynchronous2(HttpServletResponse response) throws IOException {
        System.out.println("ConNoteController.asynchronous2");
        Emp emp = new Emp(200, "noby", null);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), emp);
    }

    /**
     * 使用统一的响应格式（封装为一个响应对象）
     */
    @ResponseBody
    @RequestMapping("/ResponseResult.do")
    public ResponseResult<Emp> ResponseResult() {
        System.out.println("ConNoteController.ResponseResult");
        Emp emp = new Emp(200, "noby", null);
        return new ResponseResult<>(200, "ok", emp);
    }

    /**
     * requestBody 的使用
     *
     * @RequestBody 将前端发送的异步json数据接收后转化成对象（和 @ResponseBody 相反）
     * 因 get 请求没有请求体，所以不能使用
     * 前端请求的 contentType:"application/json;charset=utf-8" 表示发送 json 格式的请求参数（默认发送的为键值对的请求参数）
     */
    @ResponseBody
    @RequestMapping("/requestBody.do")
    public Emp requestBody(@RequestBody Emp emp) {
        System.out.println("ConNoteController.requestBody");
        System.out.println("emp = " + emp);
        return emp;
    }

    /**
     * 日期属性的处理
     *
     * @DateTimeFormat(pattern="yyyy-MM-dd") Date的类型转换器可直接使用该注解(测试前注释掉在配置文件中声明的转换器)
     */
    @ResponseBody
    @RequestMapping("/date.do")
    public Date data(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        System.out.println("ConNoteController.date");
        System.out.println("date = " + date);
        return date;
    }

    /**
     * 对象封装时日期属性的处理
     */
    @ResponseBody
    @RequestMapping("/date2.do")
    public Emp data2(Emp emp) {
        System.out.println("ConNoteController.date2");
        System.out.println("emp = " + emp);
        return emp;
    }

    /**
     * 日期的通用解决办法：配置日期格式转换器（实现转换器接口）,配置该转换器后，属于日期的参数均会调用该日期转换器
     * 1、定义转换器类并实现Converter接口
     * 2、SpringMVC中配置转换器
     */
    @ResponseBody
    @RequestMapping("/date3.do")
    public Date data3(Date date) {
        System.out.println("ConNoteController.date3");
        System.out.println("date = " + date);
        return date;
    }

    /**
     * 同步异常处理
     */
    @RequestMapping("/exception.do")
    public ModelAndView exception() {
        System.out.println("ConNoteController.exception");
        ModelAndView modelAndView = new ModelAndView();
        try {
            System.out.println("UserController.exception");
            int i = 1 / 0;
            return modelAndView;
        } catch (Exception e) {
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.setViewName("/msg.jsp");
            return modelAndView;
        }
    }


    /**
     * 异步异常处理
     */
    @ResponseBody
    @RequestMapping("/exception2.do")
    public ResponseResult<String> exception2() {
        System.out.println("ConNoteController.exception2");
        ResponseResult<String> responseResult;
        try {
            int i = 1 / 0;
            responseResult = new ResponseResult<>(200, "ok", "info");
            return responseResult;
        } catch (Exception e) {
            responseResult = new ResponseResult<>(500, e.getMessage(), null);
            return responseResult;
        }
    }


    /**
     * 设置统一的异常处理（定义在Controller中），SpringMVC的底层是AOP
     *
     * @ExceptionHandler 为异常处理注解，只要本类有controller发生异常都会执行本方法
     */
    @ExceptionHandler
    public void exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException, ServletException {
        System.out.println("ConNoteController.exceptionHandler");
        if (request.getHeader("X-Requested-With") != null) {
            System.out.println("异步异常处理");
            new ObjectMapper().writeValue(response.getWriter(), new ResponseResult<>(500, e.getMessage(), null));
        } else {
            System.out.println("同步异常处理");
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }
    }

    /**
     * 设置统一的异常处理（定义在Controller中），SpringMVC的底层是AOP
     *
     * @ExceptionHandler(ArithmeticException.class) 表示指定处理某一种异常
     */
    @ExceptionHandler(ArithmeticException.class)
    public void arithmeticException(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException, ServletException {
        System.out.println("ConNoteController.arithmeticException");
        if (request.getHeader("X-Requested-With") != null) {
            System.out.println("异步异常处理arithmeticException");
            new ObjectMapper().writeValue(response.getWriter(), new ResponseResult<>(500, e.getMessage(), null));
        } else {
            System.out.println("同步异常处理arithmeticException");
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }
    }

    /**
     * 统一同步异常处理测试
     */
    @RequestMapping("/exception3.do")
    public ModelAndView exception3() {
        System.out.println("ConNoteController.exception3");
        ModelAndView modelAndView = new ModelAndView();
//        String str = null;
//        str.equals("null");
        int i = 1 / 0;
        return modelAndView;
    }

    /**
     * 统一异步异常处理测试
     */
    @ResponseBody
    @RequestMapping("/exception4.do")
    public ResponseResult<String> exception4() {
        System.out.println("ConNoteController.exception4");
        ResponseResult<String> responseResult;
        int i = 1 / 0;
        responseResult = new ResponseResult<>(200, "ok", "info");
        return responseResult;
    }

    /**
     * 文件上传
     * 一般前端为 post 请求（get 请求有大小限制）添加属性 method="post" enctype="multipart/form-data"
     * MultipartFile 为 commons-fileupload jar 包提供的多部件接口
     * img 为前端 <input> 表单的 name 值
     */
    @ResponseBody
    @RequestMapping("/fileupload.do")
    public ResponseResult<String> fileupload(MultipartFile img) {
        System.out.println("ConNoteController.fileupload");
        ResponseResult<String> responseResult;
        File file = new File("D:\\image", UUID.randomUUID()+img.getOriginalFilename());
        try {
            img.transferTo(file);
            responseResult = new ResponseResult<>(200, "ok", "info");
            return responseResult;
        } catch (IOException e) {
            e.printStackTrace();
            responseResult = new ResponseResult<>(500, "error", "info");
            return responseResult;
        }
    }
}
