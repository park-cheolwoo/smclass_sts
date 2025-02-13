package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ReController {

	@Autowired EventService eventService;
	@Autowired HttpSession session;

	@PostMapping("/event/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println("eno : "+cdto.getEno());
		System.out.println("cpw : "+cdto.getCpw());
		System.out.println("ccontent : "+cdto.getCcontent());
		cdto.setId("aaa");
//		String id = (String)session.getAttribute("session_id");
		
		System.out.println("cwrite 저장 전 : "+cdto.getCno());
		CboardDto cboardDto = eventService.cwrite(cdto);
		System.out.println("cwrite 저장 후: "+cboardDto.getCno());
		System.out.println("cwrite 저장 후: "+cboardDto.getCdate());
		
		return cboardDto;
	}
}
