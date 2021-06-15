package com.htp.bynews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htp.bynews.constant.Message;
import com.htp.bynews.entity.User;
import com.htp.bynews.model.LoginForm;
import com.htp.bynews.service.AnyTypeUserService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import com.htp.bynews.service.ServiceException;

@Controller
//@RequestMapping("/login")
public class SignIn {
	
	@Autowired
	AnyTypeUserService anyTypeUserService;
	
	@GetMapping("/login")
	public String ShowSignInPage(Model model) {
		
		// create a loginForm object
		LoginForm loginForm = new LoginForm();
				
		// add loginForm object to the model
		model.addAttribute("loginForm", loginForm);
		
		return "login";
	}
	
	@PostMapping("/login")
	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	//public String processSignIn(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
	public String processSignIn(Model model, @ModelAttribute("loginForm") LoginForm loginForm, RedirectAttributes redirectAttr) {
		
		// log the input data
		System.out.println("Register data: " + loginForm.getUsername()
							+ " " + loginForm.getPassword());
		
		try {
			User user = anyTypeUserService.getUserInstance(loginForm.getUsername(), loginForm.getPassword());
			if(user == null) {
				redirectAttr.addFlashAttribute("message_redirect", Message.LOGINATION_ERR);
				return "redirect:/home";
			}
			
		} catch(ServiceException exception) {
			model.addAttribute("message", Message.USER_SERV_ERR);
		}
		
		redirectAttr.addFlashAttribute("message_redirect", "Login is success!");
		//model.addAttribute("message_redirect", "Login is success!");
		return "redirect:/home";
	}

}