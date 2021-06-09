package com.htp.bynews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htp.bynews.model.LoginForm;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/login")
public class SignIn {
	
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
	public String processSignIn(@ModelAttribute("loginForm") LoginForm loginForm, RedirectAttributes redirectAttr) {
		
		// log the input data
		System.out.println("Register data: " + loginForm.getLogin()
							+ " " + loginForm.getPassword());
		
		redirectAttr.addFlashAttribute("message_redirect", "Login is success!");
		//model.addAttribute("message_redirect", "Login is success!");
		return "redirect:/home";
	}

}