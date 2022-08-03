springboot2 2022/6/14

* springboot 整合 MyBatis
  * 导入坐标
    * mybatis 的场景启动器
    * jdbc
  * properties 配置文件
    * 配置实体类包扫描
    * 配置映射文件路径
    * 配置数据库连接
  * 启动类上加 @MapperScan("priv.noby.springboot.dao") 配置 dao 实体类包扫描 
  * 事务管理
    * 启动类配置 @EnableTransactionManagement
    * 事务类配置 @Transactional
  * 配置第三方数据源
    * pom 坐标设置
    * 配置文件配置连接参数
  * 通过实现 InitializingBean 接口的第三方类实现 springboot 中的数据共享
  * 数据共享类
    