package priv.noby.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.springsecurity.entity.ResponseResult;

//允许前端跨域
//@CrossOrigin
@RestController
public class TestController {
    @PreAuthorize("hasAnyAuthority('t')")
    @RequestMapping("/test")
    public ResponseResult<String> test() {
        return new ResponseResult<String>(200,"y","info");
    }
    @PreAuthorize("hasAnyAuthority('t2')")
    @RequestMapping("/test2")
    public ResponseResult<String> test2() {
        return new ResponseResult<String>(200,"y","info2");
    }
}
