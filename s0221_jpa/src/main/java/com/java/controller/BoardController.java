package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	@GetMapping("/board/blist")
	public String blist(Model model) {		
		List<BoardDto> list = boardService.findAll(); // jpa에서는 arrayList가 아닌 이 부모인 List로 받음
		model.addAttribute("list",list);
		return "blist";
	}
	
	@GetMapping("/bview")
	public String bview(int bno,Model model) {		
		BoardDto boardDto = boardService.findById(bno); // jpa에서는 arrayList가 아닌 이 부모인 List로 받음
		model.addAttribute("bdto",boardDto);
		return "bview";
	}
}
