spring3Note
2022/6/1

* Spring 中的事务
  * 事务的配置
    * 约束头
      * xmlns:tx="http://www.springframework.org/schema/tx"
      * http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd">
    * 配置事务注解驱动
    * 配置事务管理 bean
  * 需要事务管理的方法上加入注解 @Transactional
    * 设置隔离级别：@Transactional(propagation=Propagation.REQUIRES_NEW)

