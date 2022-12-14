maven
2022/5/30

* maven 的基本使用
  * 坐标的组成
    * 组织id
    * 项目id
    * 版本号
  * maven 的依赖管理
    * 依赖的坐标配置
      * 依赖的范围: <scope> 标签
        * compile(log4j)(默认)  主代码、测试代码、打包
        * test(junit) 测试代码
        * provided(servlet-api) 主代码、测试代码
        * runtime(jdbc) 打包
    * 依赖具有传递性
      * 直接依赖：在当前项目中通过依赖配置建立的依赖关系
      * 间接依赖：被资源的资源如果依赖其他资源，当前项目间接依赖其他资源
    * maven 的依赖冲突
      * 打开 pom 文件，点击下方的 Dependency Analyzer 查看依赖冲突
      * 依赖传递中的冲突问题
        * 路径优先：当依赖中出现相同的资源时，层级越深，优先级越低，层级越浅，优先级越高
        * 声明优先：当资源在相同层级被依赖时，配置顺序靠后的覆盖配置顺序靠前的
      * 如何解决依赖冲突
        * 排除依赖：使用 <exclusions> 标签排除部分 jar 包的依赖
  * maven 的生命周期
    * clear 清除
    * compile 编译（生成 target 目录）
    * package 打包（target 目录中生成 jar 包）
    * install 安装（在本地仓库中生成 jar 包）
    * deploy 部署（在远程仓库中生成 jar 包）
  * 可使用跳过方式跳过生命周期的 test 执行


