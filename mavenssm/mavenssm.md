# mavenssm

* maven的聚合和继承
    * 继承：父项目打包，子项目不打包；子项目会继承父项目已经引入的坐标；其应用场景为分布式
    * 开发（继承+聚合）
        * 父项目
            *  打包方式`<packaging>pom</packaging>`
            * `<dependencyManagement>`版本锁定:不会真正添加依赖，规定后面引入依赖时使用的版本，子项目使用该依赖时就可省略版本的指定，当子项目的版本与该规定不同时，使用子项目的版本
        * 子项目
            * 不需要指定打包方式
            * 子项目坐标的 <groupId><version> 都继承自父项目 只需要配置子项目的 <artifactId>
            * 使用 parent 标签指定当前项目的父项目`<parent>
              <groupId>com.woniuxy</groupId>
              <artifactId>a01</artifactId>
              <version>1.0-SNAPSHOT</version>
              </parent>`
    * 聚合：其子模块不会继承父模块，父模块打包，所有的子模块都会打包；子模块不会继承父模块引入的坐标；其应用场景为 SpringBoot 项目
        * 父模块
            * 打包方式`<packaging>pom</packaging>`
            * 指定当前聚合模块中的子模块：`<modules>
              <module>../b02</module>
              </modules>`
        * 子模块