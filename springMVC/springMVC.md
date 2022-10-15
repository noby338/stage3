springMVC
2022/6/8

* 使用通过配置文件配置、使用 springMVC
  * 坐标（该坐标包括了4个spring的核心包和AOP和web包）
    * `<dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.15.RELEASE</version>
    </dependency>`
  * web.xml 中配置 DispatcherServlet 及访问路径
    * `<servlet-mapping>` 中 `<url-pattern>` 配置的三种方式
      * *.do (传统方式)
      * /* (避免使用)
      * /
        * 解决 restful 风格访问不了静态页面问题
          * spring 配置文件中加入约束头
            * xmlns:mvc="http://www.springframework.org/schema/mvc"
            * http://www.springframework.org/schema/mvc
              http://www.springframework.org/schema/mvc/spring-mvc.xsd
          * <mvc:default-servlet-handler/>
  * spring 配置文件中 Controller 的 bean
* springMVC 的结构及执行流程
  * DispatcherServlet 中央调度器，前端控制器 
    * 就是SpringMVC封装的Servlet(Service),我们二阶段有个BaseServlet
  * HandlerMapping 处理器映射器
    * 根据用户的请求路径，匹配处理这个请求的处理器
  * HandlerAdapter 处理器适配器
    * 处理器适配器适配器用来调用处理器，底层使用了适配器模式（不同的接口提供一种统一的调用方法）
  * Controller 处理器
    * 执行请求
  * ModelAndView    同步请求使用的
    * Model    数据            默认就是request域中的数据
    * View    视图(页面)       默认就是转发的页面        “f:/a.jsp”    "r:/ajsp"    “forward:/a.jsp”
  * ViewResolver 视图解析器
    * 查找指定的页面
