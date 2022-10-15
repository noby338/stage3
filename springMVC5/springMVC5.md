springMVC5
2022/10/11

* SpringMVC数据的请求参数的类型
  * 基本类型参数
    * 参数列表中的参数将会直接由请求参数获取并赋值
    * @RequestParam()注解修改请求参数和controller方法参数列表的参数名映射关系
    * @PathVariable()注解配置Restful风格请求参数名和controller方法参数列表的参数名映射关系
    * 通过@RequestHeader()获取指定的请求头
    * 通过@CookieValue()获取指定的Cookie
  * entity类型参数
    * 参数列表中对象的属性将会直接由请求参数获取并封装
    * 解析请求体中的json字符串使用@RequestBody注解，且将其封装到形参的对象中
    * 自定义类型转换器的使用
  * 数组类型参数
    * 参数列表中的参数将会直接由请求中的多个同名请求参数获取并赋值到数组
  * 集合类型参数
    * urlencoded参数集合类型的封装有别于其他类型，他一般借助其他类进行封装
    * 解析请求体中的json字符串使用@RequestBody注解，且将其封装到形参的对象中
* 文件的上传
    

