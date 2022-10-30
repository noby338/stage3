package priv.noby.spring8.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import priv.noby.spring8.entity.Emp;
import priv.noby.spring8.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * spring 通过web配置文件中配置监听器配置 servlet
 */
@WebServlet("/empServlet")
public class EmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        //可读取web配置文件监听器的方式读取Spring配置文件
        /*
        应用上下文对象(Spring上下文对象)如果是通过new ClasspathXmlApplicationContext(spring配置文件)方式获取的，那么每次从
        容器中获得Bean时都要编写new ClasspathXmlApplicationContext(spring配置文件)，这样的弊端是配置文件加载多次，应用上下文对象创建多次。
        在Web项目中，可以使用ServletContextListener.监听Web应用的启动，我们可以在Web应用启动时，就加
        载Spring的配置文件，创建应用上下文对象Application Context,在将其存储到最大的域servletContext域
        中，这样就可以在任意位置从域中获得应用上下文Application Context对象了。
        上面的分析不用手动实现，Spring提供了一个监听器ContextLoaderListener就是对上述功能的封装，该监
        听器内部加载Spring配置文件，创建应用上下文对象，并存储到ServletContext域中，提供了一个客户端工
        具WebApplicationContextUtils供使用者获得应用上下文对象。
        所以我们需要做的只有两件事：
        ①在web.xml中配置ContextLoaderListener监听器（导入spring-web坐标
        ②使用WebApplicationContextUtils获得应用上下文对象ApplicationContext
         */
//        ApplicationContext applicationContext = (ApplicationContext) this.getServletContext()
//                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        EmpService empService = (EmpService) applicationContext.getBean("empService");
        String method = request.getParameter("method");
        if ("init".equals(method)) {
            List<Emp> empList = empService.selectAll();
            String s = JSON.toJSONString(empList, SerializerFeature.DisableCircularReferenceDetect);
            response.getWriter().write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
