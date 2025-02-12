package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.CustomerService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	@GetMapping("/customer/notice")
	public String notice(Model model) {
		//현재날짜
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		System.out.println("현재날짜 : "+today);
		
		ArrayList<BoardDto> list = customerService.notice();
		model.addAttribute("list",list);	
		model.addAttribute("today",today);
		return "customer/notice";
	}
	
	@GetMapping("/customer/nview")
	public String nview(int bno,Model model){
		Map<String, Object> map = new HashMap<>();
		model.addAttribute("bdto",map.get("boardDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		System.out.println("boardDto : "+map.get("boardDto"));
		System.out.println("prevDto : "+map.get("prevDto"));
		return "customer/nview";
	}
	

}
