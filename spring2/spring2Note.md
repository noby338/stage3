spring2Note
2022/6/1

* 使用注解配置 Spring 
  * 使用注解之前配置文件必须配置组件扫描
  * 注解
    * Spring 实例化
      * @Component 使用在类上用于实例化Bean
      * @Controller 使用在web层类上用于实例化Bean
      * @Service 使用在service层类上用于实例化Bean
      * @Repository 使用在dao层类上用于实例化Bean
    * @Scope bean的作用范围
    * @Value 基本数据类型赋值
    * 引用数据类型注入
      * @Autowired 引用数据类型属性类型自动注入 @Qualifier 属性名自动注入
      * @Qualifier("") 配合 @Autowired 通过属性名赋值
      * @Resource("") (新注解)引用数据类型自动注入（属性类型、属性名）
    * @PostConstruct 使用在方法上标注该方法是Bean的初始化方法
    * @PreDestroy 使用在方法上标注该方法是Bean的销毁方法
* 复杂属性赋值必须通过配置文件或配置类
