package cz.jiripinkas.jba.service.impl;



import com.tangzq.vo.ArticleVo;
import cz.jiripinkas.jba.entity2.Reply;
import cz.jiripinkas.jba.entity2.Topic;
//import cz.jiripinkas.jba.service.ReplyService;
import cz.jiripinkas.jba.service.TopicService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangzhiqiang
 */
@Service
public class ArticleServiceImpl implements com.tangzq.service.ArticleService {

    @Autowired
    private TopicService2 topicService;

//    @Autowired
//    private ReplyService replyService;

    @Override
    public ArticleVo findArticleVo(String topicId) {
        Topic topic=topicService.findTopicById(topicId);
 //       List<Reply> replyList=replyService.findReplyByTopicId(topicId);
        List<Reply> replyList=new ArrayList<Reply>();
        ArticleVo vo=new ArticleVo();
        vo.setTopic(topic);
        vo.setReplyList(replyList);
        return vo;
    }
}
