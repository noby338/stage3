package priv.noby.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.note.constant.Constant;
import priv.noby.note.entity.Student;

/**
 * @author Noby
 * @since 2022/10/16
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/selectById")
    public String selectById(int id) {
        String info = String.format("访问成功,id = %d",id) ;
        System.out.println("info = " + info);
        return info;
    }

    //region 获取注入来自yml的配置参数的方式1
    @Value("${studentname}")
    private String studentname;

    @Value("${student.age}")
    private String age;

    @Value("${addresses[0]}")
    private String address0;

    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;

    @GetMapping("/getYmlValue")
    public String getYmlValue() {
        System.out.println("studentname = " + studentname);
        System.out.println("age = " + age);
        System.out.println("address0 = " + address0);
        System.out.println("msg1 = " + msg1);
        System.out.println("msg2 = " + msg2);
        return null;
    }
    //endregion 获取注入来自yml的配置参数的方式1


    //region 获取注入来自yml的配置参数的方式2
    //来自springframework.core的类
    @Autowired
    private Environment environment;

    @GetMapping("/getYmlValue2")
    public String getYmlValue2() {
        System.out.println("environment.getProperty(\"studentname\") = " + environment.getProperty("studentname"));
        System.out.println("environment.getProperty(\"student.age\") = " + environment.getProperty("student.age"));
        System.out.println("environment.getProperty(\"addresses[0]\") = " + environment.getProperty("addresses[0]"));
        System.out.println("environment.getProperty(\"msg1\") = " + environment.getProperty("msg1"));
        System.out.println("environment.getProperty(\"msg2\") = " + environment.getProperty("msg2"));
        return null;
    }
    //endregion 获取注入来自yml的配置参数的方式2

    //region 获取注入来自yml的配置参数的方式3
    //entity上书写注解@ConfigurationProperties(prefix = "student")
    @Autowired
    private Student student;

    @GetMapping("/getYmlValue3")
    public String getYmlValue3() {
        System.out.println("student = " + student);
        return null;
    }
    //endregion 获取注入来自yml的配置参数的方式3
    //利用InitializingBean接口
    @GetMapping("/getYmlValue4")
    public String getYmlValue4() {
        System.out.println("Constant.INFORMATION = " + Constant.INFORMATION);
        return null;
    }
    //endregion 获取注入来自yml的配置参数的方式3
}
