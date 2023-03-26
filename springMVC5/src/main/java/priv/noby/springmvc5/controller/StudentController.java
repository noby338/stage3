package priv.noby.springmvc5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import priv.noby.springmvc5.entity.Student;
import priv.noby.springmvc5.entity.VO;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * SpringMVC数据的请求的参数的类型
 * <p>
 * 基本类型参数
 * entity类型参数
 * 数组类型参数
 * 集合类型参数
 *
 * @author Noby
 * @since 2022/10/11
 */
@Controller
//可设置响应的编码格式 produces = "application/json;charset=utf-8"
@RequestMapping(value = "/student", produces = "application/json;charset=utf-8")
//@RequestMapping(value="/student")
//简易的请求方式约束，同@RequestMapping()的method属性
//    @GetMapping()
//    @PostMapping()
//    @PutMapping()
//    @DeleteMapping()
public class StudentController {

    /**
     * 基本类型参数
     *
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public String select(String name, int age) {
        /*
        参数列表中的name和age将会直接由请求参数获取并封装
        因为参数列表中的任何参数都应该为String，因此int age实质上是由String转换过来的(通过SpringMVC自动的类型转换器)
         */
        System.out.println("StudentController.select");
        String format = String.format("获取到数据 name=%s,age=%d", name, age);
        System.out.println(format);
        return format;
    }

    /**
     * entity类型参数的封装
     *
     * @return
     */
    @RequestMapping("/select2")
    @ResponseBody
    public String select2(Student student) {
        /*
        参数列表中的Student将会直接由请求参数获取并封装
        只要有entity中存在与请求参数相同的属性即可封装
         */
        System.out.println("StudentController.select2");
        String format = String.format("获取到数据 %s", student);
        System.out.println(format);
        return format;
    }

    /**
     * 数组类型的封装
     *
     * @return
     */
    @RequestMapping("/select3")
    @ResponseBody
    public String select3(int[] nums) {
        /*
        参数列表中的int[]将会直接由请求参数获取并封装
        只要有请求参数中的name和参数列表中的形参相同即可封装
         */
        System.out.println("StudentController.select3");
        String format = String.format("获取到数据 %s", Arrays.toString(nums));
        System.out.println(format);
        return format;
    }


    /**
     * 集合类型借助VO类的的封装
     *
     * @return
     */
    @RequestMapping("/select4")
    @ResponseBody
    public String select4(VO vo) {
        /*
        集合类型的封装有别于其他类型，他一般借助其他类进行封装
         */
        System.out.println("StudentController.select4");
        String format = String.format("获取到数据 %s", vo);
        System.out.println(format);
        return format;
    }

    /**
     * 集合类型借助@RequestBody注解的的封装
     * <p>
     * 接收的请求为json的post请求
     *
     * @return
     */
    @RequestMapping("/select5")
    @ResponseBody
    public String select5(@RequestBody List<Student> studentList) {
        /*
        @RequestBody参数用于解析请求体中的json字符串，且将其封装到形参的对象中
         */
        System.out.println("StudentController.select5");
        String format = String.format("获取到数据 %s", studentList);
        System.out.println(format);
        return format;
    }

    /**
     * 基本类型参数 @RequestParam 注解的使用
     * <p>
     * 当请求的参数名称与Controller的业务方法参数名称不一致时，就需要通过@RequestParam注解显示的绑定
     *
     * @return
     */
    @RequestMapping("/select6")
    @ResponseBody
    public String select6(@RequestParam("username") String name, @RequestParam(value = "userAge", required = false, defaultValue = "18") int age) {
        /*
        @RequestParam("username")表示请求参数username和方法形参name映射
        属性required = false表示指定的请求参数是否必须包括，默认是true，提交时如果没有此参数则报错
        属性defaultValue：当没有指定请求参数时，则使用指定的默认值赋值
         */
        System.out.println("StudentController.select6");
        String format = String.format("获取到数据 name=%s,age=%d", name, age);
        System.out.println(format);
        return format;
    }

    /**
     * 基本类型参数 @PathVariable 注解的使用
     * <p>
     * 使用Restful风格请求参数(Restful风格的请求是使用“url+请求方式”表示一次请求目的的)
     *
     * @return
     */
    @RequestMapping(value = "/select7/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String select7(@PathVariable("userId") int id) {
        /*
        @PathVariable()注解配置Restful风格请求参数名和controller方法参数列表的参数名映射关系
         */
        System.out.println("StudentController.select7");
        String format = String.format("获取到数据 id=%d", id);
        System.out.println(format);
        return format;
    }


    /**
     * 自定义类型转换器的使用
     * <p>
     * 之前的接收参数中的String转换为int实际上是通过SpringMVC自动的类型转换器转换过来的(SpringMVC还有其他的参数可以自动转换)
     * 对于复杂的数据类型(例如日期)需要自定义转换方式
     * 步骤：
     * ① 定义转换器类实现Converter接口
     * ② 在配置文件中声明转换器
     * ③ 在<annotation-driven>中引用转换器
     *
     * @return
     */
    @RequestMapping("/select8")
    @ResponseBody
    //Date的类型转换器可直接使用该注解(测试前注释掉在配置文件中声明的转换器)
//    public String select8(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    public String select8(Date date) {
        /*
        Date默认可封装"2022/10/14"字符串为Date
        自定义为"2022-10-14"字符串封装为Date
         */
        System.out.println("StudentController.select8");
        String format = String.format("获取到数据 date=%s", date);
        System.out.println(format);
        return format;
    }

    /**
     * 通过@RequestHeader()获取指定的请求头
     */
    @RequestMapping("/select9")
    @ResponseBody
    public String select9(@RequestHeader(value = "User-Agent", required = false) String userAgent) {
        System.out.println("StudentController.select9");
        String format = String.format("获取到数据 userAgent=%s", userAgent);
        System.out.println(format);
        return format;
    }

    /**
     * 通过@CookieValue()获取指定的Cookie
     * <p>
     * 可以通过@RequestHeader("Cookie")获取所有的Cookie
     */
    @RequestMapping("/select10")
    @ResponseBody
    public String select10(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        System.out.println("StudentController.select10");
        String format = String.format("获取到数据 jsessionId=%s", jsessionId);
        System.out.println(format);
        return format;
    }

    /**
     * 文件的上传
     * <p>
     * 步骤：
     * ① 导入fileupload和io坐标
     * ② Spring-mvc中配置文件上传解析器
     * ③ 编写文件上传代码
     */
    @RequestMapping("/select11")
    @ResponseBody
    public String select11(String fileName, MultipartFile uploadFile) {
        /*
        这里的fileName和uploadFile必须与表单的name属性一致
         */
        System.out.println("StudentController.select11");
        String format = String.format("获取到数据 fileName=%s", fileName);
        System.out.println(format);
        //文件的原始名(fileName为表单中的名字，通常为用户给上传的文件重命名)
        String originalFilename = uploadFile.getOriginalFilename();
        //保存文件到服务器
        try {
            uploadFile.transferTo(new File("D:\\IdeaProjects\\stage3\\springMVC5\\src\\main\\webapp\\upload\\" + fileName + ".jpg"));
//            uploadFile.transferTo(new File("D:\\IdeaProjects\\stage3\\springMVC5\\src\\main\\webapp\\upload\\" + originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return format;
    }
}
