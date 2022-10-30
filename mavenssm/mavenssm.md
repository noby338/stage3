# mavenssm

* Web项目的分模块开发
  * 每个模块中仅包含当前模块对应的功能类与配置文件
  * spring核心配置根据模块功能不同进行独立制作
  * 当前模块所依赖的模块通过导入坐标的形式加入当前模块后才可以使用(需将依赖的模块安装的本地仓库)
  * web.xml需要加载所有的spring核心配置文件
* 聚合和继承
  * 作用
    * 聚合：用于快速构建maven工程，一次性构建多个项目/模块。
      * 注意事项：参与聚合操作的模块最终执行顺序与模块间的依赖关系有关，与配置顺序无关
    * 继承：通过继承可以实现在子工程中沿用父工程中的配置。
  * 配置方式
    * 继承
        * 父项目
            * `<dependencyManagement>`版本锁定:不会真正添加依赖，规定后面引入依赖时使用的版本，子项目使用该依赖时就可省略版本的指定，当子项目的版本与该规定不同时，使用子项目的版本
        * 子项目
            * 子项目坐标的 <groupId><version> 都继承自父项目 只需要配置子项目的 <artifactId>
            * 使用 parent 标签指定当前项目的父项目
              `<parent>
              <groupId>com.woniuxy</groupId>
              <artifactId>a01</artifactId>
              <version>1.0-SNAPSHOT</version>
              <relativePath>../mavenssm/pom.xml</relativePath>
              </parent>`
    * 聚合
        * 父模块
            * 打包方式`<packaging>pom</packaging>`
            * 指定当前聚合模块中的子模块：
              `<modules>
              <module>../b02</module>
              </modules>`
        * 子模块
            * 无需指明
  * 异同：
    * 相同点：
      * 聚合与继承的pom.xml文件打包方式均为pom,可以将两种关系制作到同一个pom文件中聚合与继承均属于设计型模块，并无实际的模块内容
    * 不同点：
      * 聚合用于快速构建项目；继承用于快速配置
      * 聚合是在父模块中配置关系，父模块可以感知到参与聚合的模块有哪些；继承是在子模块中配置关系，父模块无法感知哪些子模块继承了自己
      * 聚合其子模块不会继承父模块，父模块打包，所有的子模块都会打包；子模块不会继承父模块引入的坐标；继承父项目打包，子项目不打包，子项目会继承父项目已经引入的坐标；
      * 聚合的应用场景为 SpringBoot 项目；继承其应用场景为分布式项目
* maven的属性(maven中的变量)
  * 自定义属性
    * 父项目中定义(spring.version为键，5.2.15.RELEASE为值)
    `<properties>
      <spring.version>5.2.15.RELEASE</spring.version>
    </properties>`
  * 内置属性
    * 例如：${project.version}可引用本项目的version
  * Setting属性
  * Java系统属性
  * 环境变量属性
* 项目的工程版本
  * 分类
    * SNAPSHOT(快照版本)
      * 项目开发过程中，为方便团队成员合作，解决模块间相互依赖和时时更新的问题，开发者对每个模块进行构建的时候，输出的临时性版本叫快照版本（测试阶段版本）
      * 快照版本会随着开发的进展不断更新
    * RELEASE(发布版本)
      * 项目开发到进入阶段里程碑后，向团队外部发布较为稳定的版本，这种版本所对应的构件文件是稳定的，即便进行功能的后续开发，也不会改变当前发布版本内容，这种版本称为发布版本
  * 版本号约定
    * 约定规范：
      * <主版本>.<次版本>.<增量版本>.<里程碑版本>
      * 主版本：表示项目重大架构的变更，如：spring5相较于spring4的迭代
      * 次版本：表示有较大的功能增加和变化，或者全面系统地修复漏洞
      * 增量版本：表示有重大漏洞的修复
      * 里程碑版本：表明一个版本的里程碑（版本内部）。这样的版本同下一个正式版本相比，相对来说不是很稳定，有待更多的测试
    * 范例：
      * 5.1.9.RELEASE
* 配置文件中读取pom属性值(maven统一管理其他所有的配置文件)
  1. 在pom文件中设定配置文件路径
     `<resources>
     <resource>
     <directory>${project.basedir}/src/main/resources</directory>
     <filtering>true</filtering>
     </resource>
     </resources>`
  2. 开启加载pom属性过滤功能
  3. pom中定义该属性
     `<properties>
     <jdbc.url>jdbc:mysql://127.0.0.1:3306/test(install该项目后查看jar中的db.properties是否为该值)</jdbc.url>
     </properties>`
  4. 使用其他配置文件中使用${属性名}格式引用pom属性
* 多环境开发配置
  1. 配置多环境(配置文件中读取pom属性值中的步骤3换为以下标签代替)
     `<profiles>
        <profile>
            <id>pro_env</id>
            <properties>
                <jdbc.url>jdbc:mysql://127.1.1.1:3306/ssm_db</jdbc.url>
            </properties>
        </profile>
        <profile>
            <id>dep_env</id>
            <properties>
                <jdbc.url>jdbc:mysql://127.2.2.2:3306/ssm_db</jdbc.url>
            </properties>
        </profile>
  </profiles>`
  2. 执行构建命令并指定加载对应环境配置信息
     * 方式1：使用命令行 mvn install –P pro_env
     * 方式2：利用idea ，运行的配置中，配置文件直接选择 pro_env