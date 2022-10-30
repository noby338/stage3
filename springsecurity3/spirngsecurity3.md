# springsecurity3

* springSecurity的默认认证和授权异常都为403，时机开发中认证的异常为401，授权的异常为403。若实现需要自定义认证异常和授权异常覆盖默认的框架异常
* 异常的使用
  * 全局异常
    * 使用类上使用@RestControllerAdvice配合方法使用@ExceptionHandler(异常类字节码对象)捕获所有controller中的指定异常(不可捕获认证异常和授权异常)
  * 认证异常：框架所有抛出的认证异常都将由该自定义认证异常代替
    * 自定义类实现AuthenticationEntryPoint接口，重写commence方法
    * 配置类中配置该自定义类
  * 授权异常：框架所有抛出的授权异常都将由该自定义授权异常代替
    * 自定义类实现AccessDeniedHandler接口，重写handle方法
    * 配置类中配置该自定义类