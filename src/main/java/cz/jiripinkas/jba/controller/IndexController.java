package cz.jiripinkas.jba.controller;

import cz.jiripinkas.jba.entity2.Topic;
import cz.jiripinkas.jba.repository.TopicRepository2;
import cz.jiripinkas.jba.service.ItemService;
import cz.jiripinkas.jba.service.TopicService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
	
	@Autowired
	private ItemService itemService;

    @Autowired
	private TopicService2 topicService2;
    Topic topic;

	String strReasons;
	@RequestMapping("/index")
	public String index(Model model) {

		try {
			topic=topicService2.findTopicById("1");
		}
		catch (Exception e){strReasons=e.getMessage();}
		finally {

		}

		model.addAttribute("items", itemService.getItems());
		return "index";
	}
}
