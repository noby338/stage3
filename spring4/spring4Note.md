spring4Note
2022/6/2

* 通过注解和配置类使用 Spring
  * @Configuration 用于指定当前类是一个Spring配置类，当创建容器时会从该类上加载注解
  * @ComponentScan("") 用于指定Spring在初始化容器时要扫描的包。作用和在Spring的xml配置文件中的一样 <context:component-scan base-package="priv.noby.note.entity"/>
  * @Bean 使用在方法上，标注将该方法的返回值存储到Spring容器中
  * @PropertySource 用于加载.properties文件中的配置 
  * @Import 用于导入其他配置类
* Spring整合junit(先导入Spring整合Junit包)
  * @RunWith(SpringJUnit4ClassRunner.class)
  * ContextConfiguration("classpath:applicationContext.xml")
