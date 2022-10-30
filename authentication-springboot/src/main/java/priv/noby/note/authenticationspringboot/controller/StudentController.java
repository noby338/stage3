package priv.noby.note.authenticationspringboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.note.authenticationspringboot.entity.Student;

/**
 * @author Noby
 * @since 2022/10/28
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * 跨域是否成功
     */
    @RequestMapping("/selectById/{id}")
    public Student selectById(@PathVariable("id") int id){
        System.out.println("StudentController.selectById");
        Student student = new Student();
        student.setId(id);
        return student;
    }

    /**
     * session登录认证是否成功
     */
    @RequestMapping("/afterSessionLogin")
    public String afterSessionLogin(){
        System.out.println("StudentController.afterSessionLogin");
        return "session登录认证后操作成功";
    }
    /**
     * jwt登录认证是否成功
     */
    @RequestMapping("/afterJwtLogin")
    public String afterJwtLogin(){
        System.out.println("StudentController.afterJwtLogin");
        return "jwt登录认证后操作成功";
    }
}
