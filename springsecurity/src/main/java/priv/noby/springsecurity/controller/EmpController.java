package priv.noby.springsecurity.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.noby.springsecurity.entity.Emp;
import priv.noby.springsecurity.entity.ResponseResult;
import priv.noby.springsecurity.service.EmpService;

import java.util.List;

//允许前端跨域
//@CrossOrigin
@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @PostMapping("/selectEmp/{pageNum}")
    public ResponseResult<PageInfo<Emp>> selectEmp(
            @PathVariable("pageNum") int pageNum, @RequestBody Emp emp
    ) {
        List<Emp> emps = empService.selectByEmp(pageNum, emp);
        PageInfo<Emp> page = new PageInfo<>(emps);
        return new ResponseResult<>(200, "y", page);
    }

    @DeleteMapping("/deleteEmpByEid/{eid}")
    public ResponseResult<PageInfo<Emp>> deleteEmpByEid(@PathVariable("eid") int eid) {
        boolean b = empService.deleteByEid(eid);
        if (b) {
            return new ResponseResult<>(200, "y", null);
        } else {
            return new ResponseResult<>(500, "n", null);
        }
    }

    @PutMapping("/updateEmp")
    public ResponseResult<Boolean> updateEmp(@RequestBody Emp emp) {
        boolean b = empService.updateByEmp(emp);
        return new ResponseResult<>(200, "y", b);
    }

    @PostMapping("/addEmp")
    public ResponseResult<Boolean> addEmp(@RequestBody Emp emp) {
        boolean b = empService.insert(emp);
        return new ResponseResult<>(200, "y", b);
    }
}
