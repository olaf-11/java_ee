package com.htp.bynews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.htp.bynews.constant.Message;
import com.htp.bynews.entity.News;
import com.htp.bynews.service.NewsService;
import com.htp.bynews.service.ServiceException;

@Controller
@RequestMapping("/")
public class Home {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("home")
	public String home(Model model) {
	//public String home(Model model, @ModelAttribute("message_redirect") String message_redir) {
		
		//System.out.println("\nMessage from redirect --> " + message_redir + "\n");
		
		try {
			// get customers from the service
			List<News> news = newsService.takeAll();
						
			// add the customers to the model
			model.addAttribute("news", news);
			//model.addAttribute("message", message_redir);
		
		} catch (ServiceException exception) {
			// message
			model.addAttribute("message", Message.NEWS_SERV_ERR);
		}

		return "home";
	}
	
}