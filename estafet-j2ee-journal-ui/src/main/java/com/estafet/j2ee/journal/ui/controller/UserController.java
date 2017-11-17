package com.estafet.j2ee.journal.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.estafet.j2ee.journal.dto.user.CreateUserParams;
import com.estafet.j2ee.journal.dto.user.User;
import com.estafet.j2ee.journal.ui.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/newUser")
	public String newUserForm(Model model) {
		return "newUser";
	}
	
	@GetMapping("/newUser")
	public String newUserSubmit(@ModelAttribute CreateUserParams params) {
		User user = userService.createUser(params);
		return "redirect:/user/" + user.getUserId();
	}
		
}