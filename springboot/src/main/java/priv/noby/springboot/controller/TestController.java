package priv.noby.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import priv.noby.springboot.entity.Emp3;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class TestController {
    //将 application.properties 中的配置注入到 port 变量，以便于观察当前服务器的端口
    @Value("${server.port}")
    int port;
    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "port:" + port;
    }

    /**
     * 访问 SpringBoot 的动态资源（通过 controller 访问 templates 路径下的资源）
     * 需要引入 thymeleaf 模板引擎，用于访问动态资源目录
     */
    @RequestMapping("/templates")
    public String templates() {
        System.out.println("TestController.templates");
        return "a";//springboot 默认配置了视图解析器，可省略前后缀
//        return "/a.html";//也可不省略访问路径
//        return "forward:/a.html";//将会转发到静态资源路径（forward 会导致视图解析器不起作用）
    }

    /**
     * thymeleaf 的使用
     */
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        System.out.println("TestController.thymeleaf");
        model.addAttribute("info","information");
        model.addAttribute("htmlInfo","<strong>htmlInformation<strong/>");
        model.addAttribute("names", Arrays.asList("noby","kace","july"));
        return "thymeleaf";//springboot 默认配置了视图解析器，可省略前后缀
    }

    /**
     * springboot 拦截后跳转该 controller
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpSession session) {
        System.out.println("TestController.login");
        ModelAndView modelAndView = new ModelAndView();
        session.setAttribute("user", "noby");
        modelAndView.setViewName("/index.html");
        return modelAndView;
    }

    /**
     * springboot 日期转换器
     * 配置文件中指定转换格式
     */
    @ResponseBody
    @RequestMapping("/date")
    public void date(Emp3 emp3) {
        System.out.println("TestController.date");
        System.out.println("emp3 = " + emp3);
    }

    /**
     * springboot 上传文件到虚拟目录
     * 配置类中配置文件上传，配置文件中配置虚拟目录
     */
    @ResponseBody
    @RequestMapping("/upload")
    public void upload(MultipartFile img) throws IOException {
        System.out.println("TestController.upload");
        File file = new File("D:/image/", img.getOriginalFilename());
        img.transferTo(file);
    }
}
