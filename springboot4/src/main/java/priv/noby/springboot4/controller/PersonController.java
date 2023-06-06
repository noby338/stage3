package priv.noby.springboot4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常的捕获
 *
 * @author Noby
 * @since 2022/10/22
 */
@RequestMapping(value = "/person",produces = "application/json;charset=utf-8")
@RestController
public class PersonController {

    @GetMapping("/createNullPointer")
    public String createNullPointer() {
        System.out.println("PersonController.createNullPointer");
        String str = null;
        //下行异常将被配置的全局异常捕获
        str.equals("null");
        return "未发生异常";
    }

}
