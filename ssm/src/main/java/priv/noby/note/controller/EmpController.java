package priv.noby.note.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import priv.noby.note.entity.Emp;
import priv.noby.note.service.EmpService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class EmpController {
    @Autowired
    EmpService empService;
    @RequestMapping("/init.do")
    public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        List<Emp> allEmpService = empService.findAll();
        String json = JSON.toJSONString(allEmpService);
        modelAndView.addObject("json",json);
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }
}
