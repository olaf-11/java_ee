package com.htp.bynews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
	
	@GetMapping("home")
	public String home(Model model) {
		model.addAttribute("message", "Start is OK!");
		return "home";
	}
}