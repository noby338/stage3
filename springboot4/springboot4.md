# springboot4

* springboot中拦截器的使用
  * 配置拦截器(实现HandlerInterceptor接口的类)
  * 定义配置类，配置拦截路径和放行路径
* springboot中添加虚拟目录映射
  * 配置类中配置
* springboot中转换器的使用
  * 配置文件中配置或使用@DateTimeFormat(pattern = "yyyy-MM-dd")注解
* springboot中项目虚拟目录和本地磁盘的映射配置
  * 配置类中配置
* 日志的使用
  * 配置中配置
  * logback 的日志级别（级别从低到高）
    * Trace:是追踪，就是程序推进以下，你就可以写个trace输出，所以trace应该会特别多，不过没关系，我们可以设置最低日志级别不让他输出。
    * Debug:指出细粒度信息事件对调试应用程序是非常有帮助的。
    * Info:消息在粗粒度级别上突出强调应用程序的运行过程。
    * Warn:输出警告及warn以下级别的日志。
    * Error:输出错误信息日志。
  * 通过lombok的注解@log4j使用log对象打印日志
  