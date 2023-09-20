使用步骤：

* 添加pom

```pom
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.4.2</version>
        </dependency>
```

* 设置配置文件

```yml
mybatis-plus:
  mapper-locations: classpath:/priv/noby/mybatisplus/dao/*.xml
```

* 在启动类上添加注解
    * `@MapperScan("priv.noby.mybatisplus.dao")`
* 在实体类上添加注解
    * `@TableName("emp")` 
    * `@TableId(type = IdType.AUTO)`
