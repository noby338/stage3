springMVC3
2022/10/11

* 使用SpringMVC的开发步骤：
  1. 导入SpringMVC相关坐标(spring-webmvc包括了4个spring的核心包和AOP包和spring整合servlet包)
  2. 配置web.xml核心控制器DispatcherServlet
  3. 创建Controller类和视图页面
  4. 使用注解配置Controller类中业务方法的映射地址
  5. 配置SpringMVC核心文件 spring-mvc.xml
  6. 客户端发起请求测试
* SpringMVC的执行流程
  1. 用户发送请求至中央调度器(前端控制器)DispatcherServlet。(DispatcherServlet为传统servlet共性部分的封装)
  2. DispatcherServlet收到请求调用HandlerMapping处理器映射器。
  3. 处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果 有则生成)一并返回给DispatcherServlet。
  4. DispatcherServlet调用HandlerAdapter处理器适配器。
  5. HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。
  6. Controller执行完成返回ModelAndView。
  7. HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。
  8. DispatcherServlet将ModelAndView传给ViewResolver视图解析器。
  9. ViewResolver解析后返回具体View。
  10. DispatcherServlet根据View进行渲染视图（即将模型数据填充至视图中）。DispatcherServlet响应用户

