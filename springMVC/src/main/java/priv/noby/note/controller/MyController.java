package priv.noby.note.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //存入 request 域中
        modelAndView.addObject("msg","info");
        //转发 (forward:/index.jsp 等同于/index.jsp)
        modelAndView.setViewName("forward:/index.jsp");
        //配置视图解析器后可省略前后缀的书写(对完整路径无效，如"forward:/index.jsp")
//        modelAndView.setViewName("index");
        //重定向 (底层已将服务端路径转换为客户端路径)
//        modelAndView.setViewName("redirect:/index.jsp");
        return modelAndView;
    }
}
