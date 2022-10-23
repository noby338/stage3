package priv.noby.note.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @author Noby
 * @since 2022/10/18
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     * 测试controller中的路径转发是否是进入thymeleaf动态目录
     */
    @GetMapping("/selectById")
    public String selectById(int id) {
        return "a";//springboot 默认配置了视图解析器，可省略前后缀，默认前缀为classpath:/templates/，默认后缀为.html
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
        model.addAttribute("names", Arrays.asList("noby","kace","诺比"));
        return "thymeleaf";
    }
}
