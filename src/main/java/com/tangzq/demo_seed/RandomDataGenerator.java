package com.tangzq.demo_seed;


import com.tangzq.model.Topic;
import com.tangzq.repository.TopicRepository2;
import com.tangzq.service.CategoryService;
import com.tangzq.service.TopicService2;
import com.tangzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RandomDataGenerator {
    @Autowired
    private TopicService2 topicService2;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    TopicRepository2 topicRepository2;
    @PersistenceContext
    protected EntityManager entityManager;
    @PersistenceUnit(/*unitName = "test"*/)
    private EntityManagerFactory entityManagerFactory;
    public RandomDataGenerator(TopicService2 topicService1, CategoryService categoryService1, UserService userService1,TopicRepository2 topicRepository21,EntityManager entityManager){
        this.topicService2=topicService1;
        this.categoryService=categoryService1;
        this.userService=userService1;
        this.topicRepository2 = topicRepository21;
        this.entityManager=entityManager;
    }
    public String genRandom (List<String> inText){
        int length=inText.size();
        Random rd=new Random(length);
         int r1=rd.nextInt(length);
        return null;
    }
    public void setFakeData() {
        ReadFile fdf = new ReadFile();
        List<String> ss = fdf.getTxt();
        Random rd = new Random();
        Random rd2 = new Random();
        for (int i = 0; i < 5; i++) {

            // RandomGenerator rdg= new RandomGenerator();
            int length = ss.size();
            // String ss1=  rdg.genRandom(ss);

            int r1 = rd.nextInt(length);
            String tempContent = ss.get(r1);
            while (tempContent.length() < 30) {
                tempContent = ss.get(r1 + 1);
            }
            int sLength = tempContent.length();
            int start = 0;
            if (sLength > 30) {
                start = rd2.nextInt(sLength - 20);
            }
            //  String tempTile=tempContent.substring(start,20);
            String tempTile;
            if (sLength > 20) {
                tempTile = tempContent.substring(1, 20);
            } else {
                tempTile = tempContent.substring(1, sLength);
            }
            Topic topic = new Topic();
            topic.setContent(tempContent);
            topic.setTitle(tempTile);
           // topic.setCategory(categoryService.findById("1"));
            topic.setDesc("");
            topic.setThumbURL("");
            topic.setTopicauthor(userService.getUser(1));
            topic.setauthorid(1);
            topic.setcatid(3);


 //            topicService2.addTopic(topicService2.convertToVo(topic));
            topicRepository2.save(topic);
            /*使用 entitymanager*/
    //    entityManager.getTransaction().begin();
      //  entityManager.persist(topic);
     //   entityManager.flush();
     //   entityManager.getTransaction().commit();
        }
    }
}
