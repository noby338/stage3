spring4Note
2022/6/2

* Spring AOP(面向切面编程) 的使用步骤
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


