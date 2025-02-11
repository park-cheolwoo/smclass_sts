package com.java.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService bService;
	
	@GetMapping("/board/blist")
	public String blist(@RequestParam(value="page",defaultValue="1") int page, Model model) {
		Map<String,Object> map = bService.blist(page);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("page",map.get("page"));
		model.addAttribute("maxpage",map.get("maxpage"));
		return "blist";
	}
}

