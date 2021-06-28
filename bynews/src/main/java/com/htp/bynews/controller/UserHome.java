package com.htp.bynews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.htp.bynews.constant.Message;
import com.htp.bynews.entity.News;
import com.htp.bynews.service.NewsService;
import com.htp.bynews.service.ServiceException;

@Controller
public class UserHome {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/home")
	public String uhome(Model model) {
		
		try {
			// get customers from the service
			List<News> news = newsService.takeAll();
						
			// add the customers to the model
			model.addAttribute("news", news);
			//model.addAttribute("message", message_redir);
			
		} catch (ServiceException exception) {
			model.addAttribute("message", Message.NEWS_SERV_ERR);
		}
		return "/home";
	}

}