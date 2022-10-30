package priv.noby.springsecurity2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import priv.noby.springsecurity2.entity.Dep;
import priv.noby.springsecurity2.service.DepService;

import javax.annotation.Resource;

/**
 * (Dep)表控制层
 *
 * @author Noby
 * @since 2022-10-30 14:17:39
 */
@RestController
@RequestMapping("dep")
@Slf4j
public class DepController {
    /**
     * 服务对象
     */
    @Resource
    private DepService depService;

    /**
     * 分页查询
     *
     * @param dep 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @PreAuthorize("hasAnyAuthority('dep:select')")
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<Dep>> queryByPage(@RequestBody Dep dep, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> dep = {}, page = {}, size = {}", dep, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.depService.queryByPage(dep, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PreAuthorize("hasAnyAuthority('dep:select')")
    @GetMapping("{id}")
    public ResponseEntity<Dep> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.depService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dep 实体
     * @return 新增结果
     */
    @PreAuthorize("hasAnyAuthority('dep:insert')")
    @PostMapping
    public ResponseEntity<Dep> add(@RequestBody Dep dep) {
        log.info("add ===> dep = {}", dep);
        return ResponseEntity.ok(this.depService.insert(dep));
    }

    /**
     * 编辑数据
     *
     * @param dep 实体
     * @return 编辑结果
     */
    @PreAuthorize("hasAnyAuthority('dep:update')")
    @PutMapping
    public ResponseEntity<Dep> edit(@RequestBody Dep dep) {
        log.info("edit ===> dep = {}", dep);
        return ResponseEntity.ok(this.depService.update(dep));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PreAuthorize("hasAnyAuthority('dep:delete')")
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        log.info("deleteById ===> id = {}", id);
        return ResponseEntity.ok(this.depService.deleteById(id));
    }

}

