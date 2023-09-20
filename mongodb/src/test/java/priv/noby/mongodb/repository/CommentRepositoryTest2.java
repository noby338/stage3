package priv.noby.mongodb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import priv.noby.mongodb.entity.Comment;

/**
 * 通过MongoTemplate实现更新
 * @author Noby
 * @since 2023/7/17
 */
@SpringBootTest
class CommentRepositoryTest2 {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 通过MongoTemplate数据自增
     */
    @Test
    void updateFirst() {
        Query query = Query.query(Criteria.where("_id").is("2"));
        Update update = new Update();
        update.inc("likenum");
        mongoTemplate.updateFirst(query, update, Comment.class);
    }

}