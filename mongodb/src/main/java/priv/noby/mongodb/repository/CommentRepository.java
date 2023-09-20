package priv.noby.mongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import priv.noby.mongodb.entity.Comment;

/**
 * 评论
 *
 * @author Noby
 * @since 2023/7/17
 */
public interface CommentRepository extends MongoRepository<Comment,String > {
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
