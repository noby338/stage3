package priv.noby.vuespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.noby.vuespringboot.entity.Dep;
import priv.noby.vuespringboot.entity.ResponseResult;
import priv.noby.vuespringboot.service.DepService;

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
