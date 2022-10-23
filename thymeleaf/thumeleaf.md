# thumeleaf

* thymeleaf模板引擎为在页面渲染数据的一种技术类似jsp
* springboot的模板引擎的使用
  * 引入坐标即可使用模板引擎
  * 页面的路径
    * resources目录下的static为静态资源(直接访问访问的静态资源进入该目录下)
      * 通过配置类设置请求路径的转换(请求动态资源转换到静态资源)
    * resources目录下的templates为模板引擎动态资源(controller转发的页面直接进入该目录下的资源)(在未引入模板引擎坐标的情况下进入static)
      * 使用需要引入模板引擎坐标
  