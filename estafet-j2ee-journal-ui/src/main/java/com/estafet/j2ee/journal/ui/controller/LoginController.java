package com.estafet.j2ee.journal.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.estafet.j2ee.journal.dto.user.User;
import com.estafet.j2ee.journal.ui.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		return "login";
	}
	
	@GetMapping("/login")
	public String loginSubmit(@ModelAttribute String userId) {
		User user = userService.getUser(userId);
		return user != null ? "redirect:/user/" + userId : "redirect:/newUser";
	}
	
}
