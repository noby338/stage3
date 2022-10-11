spring4Note
2022/6/2

* Spring AOP 的使用步骤
  1. 配置文件
     1. 加入约束头
        * xmlns:aop="http://www.springframework.org/schema/aop"
        * http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
     2. 加入自动织入标签
        * <aop:aspectj-autoproxy/>
  2. pom
     * 加入 jar 
       * <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.6</version>
        </dependency>
  3. 创建切面类
     * 类加入 @Aspect 注解
     * 方法加入通知(before/AfterReturning/Around/AfterThrowing/After)注解
       * 注解中配置切入点表达式
         * "execution()"
  4. 调用方法
* AOP 编程术语
    * 切面：泛指交叉业务逻辑
    * 织入：指将较差代码插入到目标对象的方法
    * 连接点：指可以被切面织入的方法
    * 目标对象：被增强的对象
    * 代理对象：被增强后的对象
    * 切入点：值切面具体织入的方法
    * 通知：切入的时间点（前置通知、后置通知）
    * 顾问：对通知的一种封装
