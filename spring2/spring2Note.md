spring2Note
2022/6/1

* 使用注解配置 Spring 
  * Spring 实例化
    * @Component 
    * @Repository dao层
    * @Service service层
    * @controller controller层
  * @Scope 作用范围
  * @Value 基本数据类型赋值
  * 自动注入
    * @Autowired 引用数据类型属性类型自动注入 @Qualifier 属性名自动注入
    * @Qualifier("") 配合 @Autowired 通过属性名赋值
    * @Resource("") 引用数据类型自动注入（属性类型、属性名）
  * @PostConstruct 执行初始化方法
  * @PreDestroy 执行销毁方法
* 复杂属性赋值必须通过配置文件或配置类
