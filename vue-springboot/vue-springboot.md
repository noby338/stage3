vue-springboot 2022/6/23

* vue 和 springboot 项目的初步使用
  * 服务器开启 8080 端口，前端开启 8081 端口(前端的端口存在端口冲突会自动调整)
  * 开启服务器允许跨域(为了访问的安全性，浏览器默认不允许请求和响应的 协议 ip地址 端口 的不同)
    * 局部类跨域：controller 上书写 @CrossOrigin
    * 全局跨域：配置配置类
  * axios 请求传参
    * get
      * params: {}
    * post
      * {}
  * 设置允许前端跨域携带凭证
    * main.js
      * axios.defaults.withCredentials = true;
  * 设置允许后端跨域携带凭证
    * 配置类中 WebMvcConfigurer
  * token 的使用
  * 全局异常处理
    * 
