# note-springboot

* 使用
  * 本项目配合前端项目note-vue项目使用
* 知识点
  * SpringSecurity配合jwt认证和授权，SpringSecurity的跨域(后端SpringSecurityConfig配置)
  * 跨域的方式
    * cors(标准的跨域处理方式)
      * 原理：通过后端响应头中携带凭证，使得浏览器不拒收来自后端的响应
    * jsonp 
      * 原理：前端script利用src标签引用不受同于限制的方式实现，只能解决get请求
    * 前端配置代理服务器
      * 原理：前端和代理服务器通信，代理服务器和后端通信，代理服务和后端的通信不受同源策略的限制
      * 方式
        * 通过nginx开启
        * 通过vue-cli自带的代理服务器
  * springboot和vue分离项目的跨域
  * easyCode插件的使用
    * springframework统一响应对象ResponseEntity的使用
    * springframework统一分页对象PageRequest的使用
    

  