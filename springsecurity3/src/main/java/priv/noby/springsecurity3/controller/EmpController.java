package priv.noby.springsecurity3.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import priv.noby.springsecurity3.entity.Emp;
import priv.noby.springsecurity3.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Emp)表控制层
 *
 * @author Noby
 * @since 2022-10-30 14:17:42
 */
@RestController
@RequestMapping("emp")
@Slf4j
public class EmpController {
    /**
     * 服务对象
     */
    @Resource
    private EmpService empService;

    /**
     * 用于测试全局异常的捕获
     */
    @GetMapping("globalException")
    public void globalException() {
        int i = 1 / 0;
    }


    /**
     * 用于测试认证异常和授权异常
     *
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PreAuthorize("hasAnyAuthority('emp:select')")
    @GetMapping("{id}")
    public ResponseEntity<Emp> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.empService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param emp  筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @PreAuthorize("hasAnyAuthority('emp:select')")
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<Emp>> queryByPage(@RequestBody Emp emp, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> emp = {}, page = {}, size = {}", emp, page, size);
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(this.empService.queryByPage(emp, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param emp 实体
     * @return 新增结果
     */
    @PreAuthorize("hasAnyAuthority('emp:insert')")
    @PostMapping
    public ResponseEntity<Emp> add(@RequestBody Emp emp) {
        log.info("add ===> emp = {}", emp);
        return ResponseEntity.ok(this.empService.insert(emp));
    }

    /**
     * 编辑数据
     *
     * @param emp 实体
     * @return 编辑结果
     */
    @PreAuthorize("hasAnyAuthority('emp:update')")
    @PutMapping
    public ResponseEntity<Emp> edit(@RequestBody Emp emp) {
        log.info("edit ===> emp = {}", emp);
        return ResponseEntity.ok(this.empService.update(emp));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PreAuthorize("hasAnyAuthority('emp:delete')")
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        log.info("deleteById ===> id = {}", id);
        return ResponseEntity.ok(this.empService.deleteById(id));
    }

}

