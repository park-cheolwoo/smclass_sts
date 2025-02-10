package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
	@GetMapping("/board/bwrite")
	public String bwrite() { // bno가 넘어오지 않아도 에러가 생기지 않음
		return "bwrite";
	}

	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto bdto, Model model) {
		boardService.bwrite(bdto);
		return "redirect:/?chkBwirte=1";
	}
	
	@GetMapping("/board/bview") 
	public String bview(@RequestParam(defaultValue="1") int bno, Model model) {
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("boardDto",boardDto);
		return "bview";
	}
	
	@GetMapping("/board/bdelete") 
	public String bdelete(@RequestParam(defaultValue="1") int bno, Model model) {
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	
	
	
	
	
	
	
	
	
}
