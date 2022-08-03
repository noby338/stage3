package priv.noby.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.springsecurity.entity.Dep;
import priv.noby.springsecurity.entity.ResponseResult;
import priv.noby.springsecurity.service.DepService;

import java.util.List;

//允许前端跨域
//@CrossOrigin
@RestController
public class DepController {
    @Autowired
    DepService depService;
    @RequestMapping("/selectAllDep")
    public ResponseResult<List<Dep>> selectAllDep() {
        List<Dep> deps = depService.selectAll();
        return new ResponseResult<>(200,"y",deps);
    }
}
