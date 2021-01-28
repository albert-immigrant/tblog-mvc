package com.tangzq.vo;


import cz.jiripinkas.jba.entity2.Reply;
import cz.jiripinkas.jba.entity2.Topic;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author tangzhiqiang
 */
@Getter
@Setter
@ToString
public class ArticleVo {
    private Topic topic;
    private List<Reply> replyList;

    public void setTopic(Topic topic) {
        this.topic=topic;
    }
}
