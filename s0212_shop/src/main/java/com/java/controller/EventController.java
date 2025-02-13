package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.service.EventService;

@Controller
public class EventController {
	
	@Autowired EventService eventService;

	@GetMapping("/event/event")
	public String event(Model model) {
		//전체 리스트 가져오기
		ArrayList<EventDto> list = eventService.event();
		model.addAttribute("list",list);
		return "event/event";
	}
	
	@GetMapping("/event/eview")
	public String eview(int eno, Model model) {
		//상세페이지 가져오기
		EventDto eventDto = eventService.eview(eno);
		//하단댓글 가져오기
		ArrayList<CboardDto> clist = eventService.clist(eno);		
		model.addAttribute("edto",eventDto);
		model.addAttribute("clist",clist);
		return "event/eview";
	}
	
	
}