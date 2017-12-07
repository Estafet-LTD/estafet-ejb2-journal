package com.estafet.j2ee.journal.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.estafet.j2ee.journal.dto.user.User;
import com.estafet.j2ee.journal.entity.JournalUser;
import com.estafet.j2ee.journal.ui.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("user", new JournalUser());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute String userId) {
		User user = userService.getUser(userId);
		return user != null ? "redirect:/user/" + userId : "redirect:/newUser";
	}

}
