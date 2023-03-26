
* spring 整合 servlet
  * 导入坐标
    * <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>5.2.15.RELEASE</version>
        </dependency>
  * web.xml配置监听器
    * <listener>
          <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
      </listener>
    * <context-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>classpath:applicationContext.xml</param-value>
      </context-param>
  * servlet 使用
    * ApplicationContext applicationContext = (ApplicationContext) this.getServletContext()
      .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
* 监听器的配置和使用
  * 其作用是监听域对象：当特定的时间发生的时候，监听的事件处理方法执行
