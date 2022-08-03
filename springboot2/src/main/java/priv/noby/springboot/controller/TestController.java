package priv.noby.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import priv.noby.springboot.entity.Emp;

import java.io.File;
import java.io.IOException;

@Controller
public class TestController {

    /**
     * springboot 日期转换器
     * 配置文件中指定转换格式
     */
    @ResponseBody
    @RequestMapping("/date")
    public void date(Emp emp) {
        System.out.println("TestController.date");
        System.out.println("emp = " + emp);
    }

    /**
     * springboot 上传文件到虚拟目录
     */
    @ResponseBody
    @RequestMapping("/upload")
    public void upload(MultipartFile img) throws IOException {
        System.out.println("TestController.upload");
        File file = new File("D:/image/", img.getOriginalFilename());
        img.transferTo(file);
    }
}
