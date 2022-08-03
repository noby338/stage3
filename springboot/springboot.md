springboot 2022/6/13

* maven的聚合和继承
  * 继承：父项目打包，子项目不打包；子项目会继承父项目已经引入的坐标；其应用场景为分布式
  * 开发（继承+聚合）
    * 父项目
      *  打包方式`<packaging>pom</packaging>`
      * `<dependencyManagement>`版本锁定:不会真正添加依赖，规定后面引入依赖时使用的版本，子项目使用该依赖时就可省略版本的指定，当子项目的版本与该规定不同时，使用子项目的版本
    * 子项目
      * 不需要指定打包方式
      * 子项目坐标的 <groupId><version> 都继承自父项目 只需要配置子项目的 <artifactId>
      * 使用 parent 标签指定当前项目的父项目`<parent>
        <groupId>com.woniuxy</groupId>
        <artifactId>a01</artifactId>
        <version>1.0-SNAPSHOT</version>
        </parent>`
  * 聚合：其子模块不会继承父模块，父模块打包，所有的子模块都会打包；子模块不会继承父模块引入的坐标；其应用场景为 SpringBoot 项目
    * 父模块
      * 打包方式`<packaging>pom</packaging>`
      * 指定当前聚合模块中的子模块：`<modules>
        <module>../b02</module>
        </modules>`
    * 子模块
* springboot 的入门使用
  * springboot 项目的构建过程
    * 添加 module
    * 选择 Spring Initializr
      * SpringBoot 项目导入的模板网址：
        * https://start.spring.io
        * https://start.aliyun.com(推荐)
      * 选择 java 8，打包方式为 jar
      * 使用的 springboot 的版本 2.3.12.RELEASE(新建后 pom 中修改)
      * 选择的依赖为 Spring Web
  * Springboot 项目的部署方式
    * jar （springboot 部署的 jar 中内置 tomcat）
    * cmd 中使用命令运行 jar 包的方式
      * java -jar + 包名 
      * java -jar --server.port=8081 + 包名 可用指定的端口运行 tomcat 服务器 
  * 服务器运行的类必须在 SpringbootApplication 所在的包，或其子包
  * 开发时同时运行多个 tomcat
    * idea Edit Configurations 中指定 configuration VM options -Dserver.port=8082
  * application.properties 启动参数别名的配置
    * server.port=${port:8083}
  * 热部署的配置
    * pom
      * `<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        </dependency>`
      * Edit Configurations 中设置
  * SpringBoot 的配置文件的格式 属性冲突的优先级：properties > yaml > yml
    * properties
    * yaml(不建议使用)
    * yml(可配置不同环境下使用的配置文件)
  * 属性值注入
    * properties
    * yml
  * 通过 @ConfigurationProperties(prefix = "") 注解实现属性值注入
  * 日志的使用
    * 配置中配置
    * logback 的日志级别（级别从低到高）
      * Trace:是追踪，就是程序推进以下，你就可以写个trace输出，所以trace应该会特别多，不过没关系，我们可以设置最低日志级别不让他输出。
      * Debug:指出细粒度信息事件对调试应用程序是非常有帮助的。
      * Info:消息在粗粒度级别上突出强调应用程序的运行过程。
      * Warn:输出警告及warn以下级别的日志。
      * Error:输出错误信息日志。
  * 页面的路径
    * static 目录为静态路径
    * templates 目录为动态路径
      * 配置模板引擎坐标
  * thymeleaf 模板引擎的使用
    * 模板引擎为在页面渲染数据的一种技术
  * 通过配置类设置请求路径的转换
  * 通过配置类设置拦截器
  * 日期转换
    * 配置文件中配置转换格式
  * 图片上传
    * SpringMVC 中设置 tomcat 虚拟目录映射到本地磁盘
    * SpringBoot 项目中存在内置 tomcat
      * 配置注解类
    