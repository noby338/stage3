springboot2 2022/6/14

* springboot 整合 MyBatis
  * 导入坐标
    * mybatis 的场景启动器
    * jdbc
  * properties 配置文件
    * 配置实体类包扫描
    * 配置映射文件路径
    * 配置数据库连接
  * 启动类上加 @MapperScan("priv.noby.mybatisgenerator.dao") 配置 dao 实体类包扫描 
  * 事务管理
    * 启动类配置 @EnableTransactionManagement
    * 事务类配置 @Transactional
  * 配置第三方数据源
    * pom 坐标设置
    * 配置文件配置连接参数
* 日志的使用
  * 配置文件中配置
* logback 的日志级别（级别从低到高）
  * Trace:是追踪，就是程序推进以下，你就可以写个trace输出，所以trace应该会特别多，不过没关系，我们可以设置最低日志级别不让他输出。
  * Debug:指出细粒度信息事件对调试应用程序是非常有帮助的。
  * Info:消息在粗粒度级别上突出强调应用程序的运行过程。
  * Warn:输出警告及warn以下级别的日志。
  * Error:输出错误信息日志。
* 通过lombok的注解@log4j使用log对象打印日志
* 热部署的配置
  * 导入pom坐标
  * 开启自动编译
  
    