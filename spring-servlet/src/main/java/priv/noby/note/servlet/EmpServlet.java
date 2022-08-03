package priv.noby.note.servlet;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import priv.noby.note.entity.Emp;
import priv.noby.note.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * spring 通过监听器配置 servlet
 */
@WebServlet(name = "EmpServlet", value = "/EmpServlet")
public class EmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext = (ApplicationContext) this.getServletContext()
                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        EmpService empService = (EmpService) applicationContext.getBean("empServiceImpl");
        System.out.println();
        System.out.println("applicationContext = " + applicationContext);
        System.out.println();
        String method = request.getParameter("method");
        //region 测试监听器
        HttpSession session = request.getSession();
        session.setAttribute("name", "noby");
        //endregion 测试监听器
        if ("init".equals(method)) {
            List<Emp> emps = empService.findAll();
            String s = JSON.toJSONString(emps);
            response.getWriter().write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
