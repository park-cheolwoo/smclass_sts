package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemDto;
import com.java.dto.StuDto;

@Controller
public class FController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member")
	public String member(MemDto mDto, Model model) {
		model.addAttribute("mem",mDto);
		return "memInfo";
	}
	
	@GetMapping("/memInfo")
	public String memInfo() {
		return "memInfo";
	}
	
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("/stuInput")
	public String stuInput(StuDto sDto, Model model){
		sDto.setTotal(sDto.getKor()+sDto.getEng()+sDto.getMath());
		sDto.setAvg(sDto.getTotal()/3.0);
		model.addAttribute("stu",sDto);
		return "stuInfo";
	}
	
	@GetMapping("/stuInfo")
	public String stuInfo() {
		return "stuInfo";
	}
	
}
