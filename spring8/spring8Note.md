spring-servletNote
2022/6/7

* spring 整合 servlet
  * 导入坐标
    * <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>5.2.15.RELEASE</version>
        </dependency>
  * servlet 使用
    * 应用上下文对象(Spring上下文对象)如果是通过new ClasspathXmlApplicationContext(spring配置文件)方式获取的，那么每次从
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
    * 可通过读取web配置文件监听器的方式读取Spring配置文件
      * <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>
        <context-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext.xml</param-value>
        </context-param>
      * ApplicationContext applicationContext = (ApplicationContext) this.getServletContext()
        .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    * 使用

