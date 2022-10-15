springMVC4
2022/10/11

* SpringMVC数据的响应的方式
  * 页面跳转(同步)
    * 直接返回字符串
      * 此种方式会将返回的字符串与视图解析器的前后缀拼接后跳转。
    * 通过ModelAndView对象返回
      * Model对象和返回字符串表示视图组合
      * 方法参数列表封装ModelAndView对象
      * 方法体内实例化ModelAndView对象
      * 使用传统的HttpServletRequest对象
  * 回写数据(异步)(用到@ResponseBody注解，表示不进行视图跳转，直接进行数据响应)
    * 直接返回字符串
      * String
      * HttpServletResponse
    * 返回对象或集合
      * 自定义对象转换为json，返回json
      * Spring-mvc.xml配置处理器映射器(有普通配置和mvc注解驱动两种方式)，处理器映射器可直接将将要返回的对象转换为json

