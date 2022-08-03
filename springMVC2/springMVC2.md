springMVC
2022/6/8

* idea http client 的使用
  * 发送同步请求
    * 发送 get 请求
    * 发送 post 请求
      * 发送键值对参数请求
        * Content-Type: application/x-www-form-urlencoded
      * 发送 json 参数请求
        * Content-Type: application/json
  * 发送异步请求
    * x-requested-with: XMLHttpRequest
* 使用注解配置 SpringMVC
  * Controller 的使用
    * springMVC 的基本使用，进入到 controller
      * Controller 中的各个注解
        * @Controller 指定为 controller
        * @RequestMapping() 标注在类和方法上，表示访问路径
        * @ResponseBody 将响应体转换为 json 字符串
      * 异步请求可返回 String void 对象
      * 同步请求一般返回 ModelAndView
    * 请求方法的指定
      * @RequestMapping() method 属性可指定接收的请求方式
      * @PostMapping() 同 @RequestMapping() 表示 post 请求
    * 通配符的使用
      * /*表示一层
      * /**表示任意层次数
    * 参数的接收
      * @RequestParam() 当请求参数和 Controller 的方法列表不一致时的处理参数
      * @RequestBody 将 json 字符串请求格式封装为对象（常用于异步请求）
    * 对象参数的接收，传递域属性
      * eid=200&ename=kace&dep.did=2&dep.dname=sale
    * 接收数组
    * 处理 post 乱码
      * web.xml 中配置
        * `<filter>
          <filter-name>characterEncodingFilter</filter-name>
          <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
          <init-param>
          <param-name>encoding</param-name>
          <param-value>utf-8</param-value>
          </init-param>
          <init-param>
          <param-name>forceEncoding</param-name>
          <param-value>true</param-value>
          </init-param>
          </filter>
          <filter-mapping>
          <filter-name>characterEncodingFilter</filter-name>
          <url-pattern>/*</url-pattern>
          </filter-mapping>`
    * 转发
      * `ModelAndView modelAndView = new ModelAndView("/forward.jsp");return modelAndView;`
      * `return "/forward.jsp";`
    * 异步请求
    * 使用 ResponseResult 对象封装响应
    * 日期参数的处理
      * @DateTimeFormat(pattern = "yyyy-MM-dd") 用于 controller 的参数列表，指定将指定格式的 String 参数封装为 date 对象
      * @DateTimeFormat() 默认解析 "yyyy/MM/dd" 的 String 参数
    * 对象封装时日期属性的处理
      * 在 entity 的属性上标注 @DateTimeFormat(pattern="yyyy-MM-dd")
    * 日期转换器的配置和使用
      1. 定义转换器类并实现Converter接口，属于日期的参数均会调用该日期转换器 
      2. SpringMVC中配置转换器
    * controller 中统一的异常处理
      * 配置 @ExceptionHandler(ArithmeticException.class) 注解的参数可指定处理的异常类（可省略）
        * 同步
        * 异步
    * 所有 controller 统一的全局异常处理
      * 定义一个类，并在该类上标注 @ControllerAdvice 注解
        * 类中定义一个方法，并在该方法上标注 @ExceptionHandler()
* 上传文件 
  * 配置 tomcat 虚拟目录
    * 修改 tomcat server.xml 配置文件
      * <Context docBase="D:\image" path="/image"/>
      * 打开 tomcat 后，访问 http://localhost:8080/image/ 即可访问到资源
  * 配置 SpringMVC
    * <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
* 配置拦截器
  * SpringMVC 中配置
  * 定义实现了 HandlerInterceptor 接口的类，重写其方法
  




