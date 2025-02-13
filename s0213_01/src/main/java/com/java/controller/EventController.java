package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.EventDto;
import com.java.service.EventService;

@Controller
public class EventController {
	
	@Autowired EventService eventService;
	
	
	@GetMapping("/event/event")
	public String elist(Model model) {
		ArrayList<EventDto> elist =  eventService.elist();
		model.addAttribute("elist",elist);
		return "event/event";
	}
}
