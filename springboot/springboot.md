springboot 2022/6/13

* springboot 项目的构建过程
  * 添加 module
  * 选择 Spring Initializr
    * SpringBoot 项目导入的模板网址：
      * https://start.spring.io
      * https://start.aliyun.com(推荐)
    * 选择 java 8，打包方式为 jar
    * 使用的 springboot 的版本 2.3.12.RELEASE(新建后 pom 中修改)
    * 选择的依赖为 Spring Web
  * 服务器运行的类必须在 SpringbootApplication 所在的包，或其子包
* SpringBoot的启动依赖
  * 在spring-boot-starter-parent中定义了各种技术的版本信息，组合了一套最优搭配的技术版本。
  * 在各种starter中，定义了完成该功能需要的坐标合集，其中大部分版本信息来自于父工程。
  * 我们的工程继承parent，引入starter后，通过依赖传递，就可以简单方便获得需要的jar包，并且不会存在版本冲突等问题。
* 使用SpringBoot的两种方式：
  * 继承parent：相当于继承自spring-boot-starter-parent
    `<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.12.RELEASE</version>
    </parent>`
  * 使用import标签：这就相当于将spring-boot-dependencies中定义的所有<dependencies>全部复制粘贴到了本项目的pom.xml中
    `<dependencyManagement>
    <dependencies>
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>${spring-boot.version}</version>
    <type>pom</type>
    <scope>import</scope>
    </dependency>
    </dependencies>
    </dependencyManagement>`
* SpringBoot的配置文件：默认配置文件名称为application
  * 分类
    * properties
    * yml/yaml(不建议使用yaml)
      * 特点：
        * 大小写敏感
        * 数据值前边必须有空格，作为分隔符
        * 使用缩进表示层级关系
        * 缩进时不允许使用Tab键，只允许使用空格（各个系统 Tab对应的 空格数目可能不同，导致层次混乱）(idea等高级编辑器可忽略)。
        * 缩进的空格数目不重要，只要相同层级的元素左侧对齐即可
        * `#`表示注释，从这个字符一直到行尾，都会被解析器忽略。
  * 在同一级目录下优先级为：
    * properties > yml > yaml
* Profile
  * profile是用来完成不同环境下，配置动态切换功能的。
  * profile配置方式
    * 多profile文件方式：提供多个配置文件，每个代表一种环境。
      * application-dev.properties/yml 开发环境
      * application-test.properties/yml 测试环境
      * application-pro.properties/yml 生产环境
    * yml多文档方式：
      * 在yml中使用 --- 分隔不同配置
  * profile激活方式
    * 配置文件：在配置文件中配置：spring.profiles.active=dev
    * 虚拟机参数：在VM options 指定：-Dspring.profiles.active=dev
    * 命令行参数：java –jar xxx.jar --spring.profiles.active=dev
* 测试类的使用
  * 添加依赖
  * 测试类添加注解
    * @RunWith(SpringRunner.class)
    * @SpringBootTest(启动类.class)



    
  
    