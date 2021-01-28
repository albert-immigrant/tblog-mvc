package cz.jiripinkas.jba.repository;

import cz.jiripinkas.jba.entity2.Reply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 评论操作类
 * @author tangzhiqiang
 */
@Repository
public interface ReplyRepository extends PagingAndSortingRepository<Reply,String> {

    /**
     * 查找文章的所有评论
     * @param topicId
     * @return
     */
    @Query(value = "select re from Reply re where re.id=?1")
    List<Reply> findAllByTopicid(String topicId);
    @Query(value = "select re from Reply re where re.id=?1")
    Optional<Reply>  findById(String id);
    @Query("DELETE Reply AS re WHERE re.id=:id")
    void deleteById(@Param("id") String replyId);
}
