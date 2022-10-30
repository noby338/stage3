package priv.noby.springboot4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 类型转换器的使用
 *
 * @author Noby
 * @since 2022/10/23
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    //可使用注解代替配置文件
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @GetMapping("/selectById")
    public Date selectById(Date date) {
        System.out.println("EmpController.selectById");
        System.out.println("date = " + date);
        return date;
    }
}
