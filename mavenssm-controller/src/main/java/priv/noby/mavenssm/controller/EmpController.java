package priv.noby.mavenssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.noby.mavenssm.entity.Emp;
import priv.noby.mavenssm.service.EmpService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/emp", produces = "application/json;charset=utf-8")
public class EmpController {
    @Resource
    EmpService empService;

    @RequestMapping("/init.do")
    @ResponseBody
    public List<Emp> init() {
        List<Emp> empList = empService.findAll();
        System.out.println("empList = " + empList);
        return empList;
    }

    /**
     * 查看get请求和响应是否乱码
     */
    @GetMapping("/getCoding")
    @ResponseBody
    public String getCoding(String mes) {
        System.out.println("mes = " + mes);
        return mes;
    }

    /**
     * 查看post请求和响应是否乱码
     */
    @PostMapping("/postCoding")
    @ResponseBody
    public String postCoding(@RequestBody String mes) {
        System.out.println("mes = " + mes);
        return mes;
    }

}
