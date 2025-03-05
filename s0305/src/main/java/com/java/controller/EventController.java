package com.java.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

	
	@GetMapping("/event/event")
	public String event(Model model) {
		return "event/event";
	}
	
	
	
}
