package com.estafet.j2ee.journal.ui.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estafet.j2ee.journal.ui.service.EntryService;

public class EntryController {

	private EntryService entryService;

	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}

	@RequestMapping("/user/{id}")
	public String user(@PathVariable String id, Model model) {
		model.addAttribute("userEntries", entryService.getUserEntries(id));
		return "user";
	}

}
