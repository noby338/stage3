springNote
2022/5/30

* spring 的基础使用（配置文件的方式）
  1. 新建配置文件 applicationContext.xml （官方推荐命名）
     1. 配置文件中配置 <bean> 标签，定义 id 和 class
  2. 调用
     1. ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
     2. StudentService studentSer = (StudentService)ac.getBean("studentSer");
* ApplicationContext 和 BeanFactory 实例化的区别
  * ApplicationContext 是 BeanFactory 的子接口
  * 使用 ApplicationContext 初始化 Spring 容器时，立即创建所有的 Bean（启动慢，第一个用户的访问速度不受影响）（推荐）
  * 使用 BeanFactory 初始化 Spring 容器时，实例化某个类时才创建该 Bean（启动快，占用更少的系统资源）
* import标签引入子配置文件
* Bean
  * Bean 的装配方式
    * 默认装配方式（常用）
      * 设值注入
        * 基本数据类型注入
        * 集合数据类型
          * 数组
          * list
          * set
          * map
          * properties
        * 引用数据类型注入
          * ref
          * 自动注入
            * byName
            * byType
      * 构造注入
    * 动态工厂装配方式
    * 静态工厂装配方式
  * Bean 的作用范围
    * singleton 单例（默认）：单例的实例化个数为一个，实例化时机为Spring容器创建时，单例对象的销毁时机为Spring容器被销毁时
    * prototype 原型：原型的实例化个数一般为多个，实例化时机为容器调用getBean()方法，原型对象的销毁时机为java的垃圾回收机制作用时
    * request
    * session
    * globalSession
  * Bean 的创建和销毁 
    * init()
    * destroy()
    