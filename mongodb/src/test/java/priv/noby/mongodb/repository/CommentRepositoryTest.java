package priv.noby.mongodb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import priv.noby.mongodb.entity.Comment;

/**
 * @author Noby
 * @since 2023/7/17
 */
@SpringBootTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    /**
     * 根据Id查询
     */
    @Test
    void testFindById(){
        System.out.println("commentRepository.findById() = " + commentRepository.findById("3"));
    }


    /**
     * 查询所有
     */
    @Test
    void testFindAll(){
        System.out.println("commentRepository.findAll() = " + commentRepository.findAll());
    }
    /**
     * 分页查询
     */
    @Test
    void testFindByParentId() {
        int count = 1;
        int size = 2;
        Page<Comment> page = commentRepository.findByParentid("3", PageRequest.of(count - 1, size));
        System.out.println("page.getContent() = " + page.getContent());
    }

    /**
     * 新增
     */
    @Test
    void testSave() {
        Comment comment = new Comment();
        comment.setContent("test content");
        System.out.println("commentRepository.save(comment) = " + commentRepository.save(comment));

    }


    /**
     * 修改
     */
    @Test
    void testSave2() {
        Comment comment = new Comment();
        comment.setId("64b502924753d07086536309");
        comment.setContent("test content2");
        System.out.println("commentRepository.save(comment) = " + commentRepository.save(comment));

    }

    /**
     * 删除
     */
    @Test
    void testDeleteById() {
        commentRepository.deleteById("64b502924753d07086536309");
    }





}