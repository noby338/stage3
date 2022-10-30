# authenticationSpringNote

* 该项目配合前端项目authentication-vue使用
  * 跨域
    * 浏览器为了请求的安全，使用同源策略，当请求的源(协议、IP地址、端口)相同时，才允许访问该源对应的cookie、localStorage 和 发送Ajax 请求，因此前后端分离项目中的两个服务器为两个源不能使用对方资源，因此需在后端通过配置类配置跨域处理(添加该配置后，后端响应给浏览器的响应头中会携带，Access-Control-Allow-Origin头，如此浏览器不再绝收该响应)
      * 同源策略：指的是如果一个 js 运行在源 A 里，那么它将不能获取源 B 中的数据，只能获取当前源中的数据，该策略针对的是不同源之间的数据，这是浏览器本身的限制。
      * 不支持同源策略的安全问题举例：浏览器请求服务器a，提交登录信息并登陆成功，服务器响应给浏览器jsessionid存放在浏览器的cookie中；此时浏览器再请求服务器b，服务器响应html文件，该html中存在访问a的ajax请求，服务器获取该html后，携带a的jsessionid执行ajax请求访问a，服务器b则间接的使用浏览器的jsession获得了浏览器用户在服务器a的登录权限操作
      * 浏览器实现同源策略的方式：当浏览器识别html中的ajax请求的源与html来源的服务器的源不同时，拒收ajax请求的响应，当ajax请求源的响应头中存在 Access-Control-Allow-Origin：html来源域 头时，表示该服务器允许来自html来与服务器的跨域，此时浏览器不再拒收ajax请求的响应
  * 认证
    * session
      * 单体项目：请求的流程是 浏览器(http请求)=>服务器(html)=>浏览器(界面)，浏览器输入正确的账号密码向服务器请求登录，服务器将user对象存储在session中，并将jsession通过响应头响应给浏览器，浏览器将jsesison存在cookie中。当该浏览器再次向该服务器请求资源时，浏览器自动携带该源的所有cookie，其中包括了jsessionid。服务器根据该jsesisonid即可找到服务器中之前的session，从而获得该user。
      * 分体项目：请求的流程是 浏览器(http请求)=>前端(ajax)=>浏览器(ajax及html)=>后端(json)=>浏览器(界面)，浏览器从前端的页面中输入正确的账号密码向后端发送ajax请求登录，由于前端和后端为两个不同的源，因此需借助跨域才能实现该访问(在后端的配置允许该前端源的跨域访问)。后端验证账号和密码的正确性后将user对象存储在session中，并将jsession通过响应头响应给浏览器，浏览器将jsesison存在cookie中。当该浏览器从前端的页面中再次向该后端发送ajax请求时，访问非同源资源浏览器并不会自动携带该后端在浏览器的cookie，所以后端每次都会生成新的session而非生一次的session。因此需在前端配置允许携带凭证(axios.defaults.withCredentials = true;)(同时后端配置类应设置允许来自其他域携带凭证)，如此前端页面便可使用ajax跨域访问后端，同时ajax访问时携带凭证，同时后端接收来自前端的凭证。因此后端便可向单体项目一样获得session
      * 移动端：session是依赖cookie存在的，因为移动端不存在cookie所以不支持使用session认证登录
    * jwt
      * 分体项目：浏览器从前端的页面中输入正确的账号密码向后端发送ajax请求登录，由于前端和后端为两个不同的源，因此需借助跨域才能实现该访问(在后端的配置允许该前端源的跨域访问)。服务器验证账号和密码的正确性后根据用户名、jwt设置的密钥和签发者等信息生成token，并通过响应头向浏览器响应该token，和使得浏览器具有存储该响应头权限的Access-Control-Expose-Headers响应头，同时前端的js中会将该token存储浏览器本地localStorage中，当该浏览器从前端的页面中再次向该后端发送ajax请求时，指定携带该token，由此实现登录认证过程。(存入token到浏览器和每个请求携带token请求头可以使用ajax的拦截器代替)
      * 移动端：移动端不依赖cookie，且支持localStorage，同分体项目可使用jwt