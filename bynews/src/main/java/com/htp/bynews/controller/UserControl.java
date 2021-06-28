package com.htp.bynews.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htp.bynews.bean.LoginForm;
import com.htp.bynews.constant.Message;
import com.htp.bynews.entity.AppUser;
import com.htp.bynews.service.ServiceException;
import com.htp.bynews.service.UserAlreadyExistException;
import com.htp.bynews.service.UserService;

@Controller
public class UserControl {
	
	@Autowired
	@Qualifier("userServiceMySql")
	private UserService userService;
	
	@GetMapping("/login")
	public String showSignInPage(Model model, 
								@ModelAttribute("redir_msg") String redir_msg) {
				
		
		if (redir_msg != null && !redir_msg.trim().isEmpty()) {
			model.addAttribute("message", redir_msg);
		}
		
		// add loginForm object to the model
		model.addAttribute("loginForm", new LoginForm());
		
		return "login";
	}
	
	@GetMapping("/signup")
	public String showSignUpPage(Model model) {
				
		// add appUser object to the model
		model.addAttribute("appUser", new AppUser());
		
		return "sign_up";
	}
	
	@PostMapping("/signup")
	public String processSignUp(@ModelAttribute("appUser") AppUser appUser, 
								Model model, RedirectAttributes redirectAttr) {
		List<String> hints = new ArrayList<>();
		boolean isWrongFields = false;
		
		// Simple validation
		if (!appUser.getPwdConfirm().equals(appUser.getPassword())) {
			
			isWrongFields = true;
			model.addAttribute("message", "Passwords don't match!");
			appUser.setPassword("");
			appUser.setPwdConfirm("");
		}
		
		if (appUser.getEmail() == null || appUser.getEmail().trim().isEmpty()) {
			isWrongFields = true;
			hints.add("Field \"E-mail\" must be not empty.");
		}
		
		if (appUser.getName() == null || appUser.getName().trim().isEmpty()) {
			isWrongFields = true;
			hints.add("Field \"Name\" must be not empty.");
		}
		
		if (isWrongFields == true) {
			if (hints.size() > 0) {
				model.addAttribute("hints", hints);
			}
			model.addAttribute("appUser", appUser);
			return "sign_up";
		}
		
		// 
		try {
			userService.registerNewUser(appUser);
		} catch (ServiceException serviceExc) {
			model.addAttribute("message", Message.USER_SERV_ERR);
			return "sign_up";
		} catch (UserAlreadyExistException exc) {
			model.addAttribute("message", exc.getMessage());
			return "sign_up";
		}
		
		// TODO a.o.k.
		redirectAttr.addFlashAttribute("redir_msg", Message.REG_OK_PARAM);
		return "redirect:/login";
	}
	
	/*
	@GetMapping("/login?error")
	public String showErrorOnSignIn (Model model) {
		//
		model.addAttribute("error", "Wrong username or password.");
		return "login";
	} */
	/*
	@PostMapping("/login")
	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	//public String processSignIn(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
	public String processSignIn(Model model, @ModelAttribute("loginForm") LoginForm loginForm, RedirectAttributes redirectAttr) {
		
		// log the input data
		System.out.println("Register data: " + loginForm.getUsername()
							+ " " + loginForm.getPassword());
		/*
		try {
			AppUser user = anyTypeUserService.getUserInstance(loginForm.getUsername(), loginForm.getPassword());
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
	} */

}