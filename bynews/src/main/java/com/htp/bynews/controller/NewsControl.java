package com.htp.bynews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htp.bynews.constant.Message;
import com.htp.bynews.entity.News;
import com.htp.bynews.service.NewsService;
import com.htp.bynews.service.ServiceException;

@Controller
@RequestMapping("/news")
public class NewsControl {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/read/{id}")
	public String readNewsPage(@PathVariable("id") int id, Model model) {

		try {
			News news = newsService.takeNewsById(id);
			model.addAttribute("news", news);
		} catch (ServiceException exception) {
			model.addAttribute("message", Message.NEWS_SERV_ERR);
		}
		return "news_read";
	}
	
	@GetMapping("/edit/{id}")
	public String editNewsPage(@PathVariable("id") int id, Model model) {
		
		try {
			News news = newsService.takeNewsById(id);
			model.addAttribute("news", news);
		} catch (ServiceException exception) {
			model.addAttribute("message", Message.NEWS_SERV_ERR);
		}
		return "news_edit";
	}
	
	@PostMapping("/save")
	public String saveNews(@ModelAttribute("news") News news, Model model) {
		
		try {
			newsService.editNews(news);
		} catch(ServiceException exception) {
			model.addAttribute("message", Message.NEWS_SERV_ERR);
		}
		return "redirect:/news/read/" + news.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String deleteNews(@PathVariable("id") int id, Model model) {
		
		try {
			newsService.deleteNewsById(id);
		} catch(ServiceException exception) {
			model.addAttribute("message", Message.NEWS_SERV_ERR);
		}
		return "redirect:/home";
	}
	
	@GetMapping("/add")
	public String addNewsPage(Model model) {

		News news = new News();
		model.addAttribute("news", news);
		return "news_add";
	}
	
	@PostMapping("/add")
	public String saveAddedNews(@ModelAttribute("news") News news, Model model, RedirectAttributes redirectAttr) {
		
		int id = -1;
		try {
			id = newsService.addNews(news);
		} catch(ServiceException exception) {
			model.addAttribute("message", Message.NEWS_SERV_ERR);
		}
		
		if(id < 0) {
			redirectAttr.addFlashAttribute("message", Message.NEWS_WASNT_ADDED);
			return "redirect:/home";
		}
		return "redirect:/news/read/" + id;
	}

}