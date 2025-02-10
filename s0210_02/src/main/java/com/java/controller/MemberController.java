package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?logout=1";
	}
	
	@PostMapping("/member/login")
		public String login(MemberDto memberdto, Model model) {
			System.out.println("MemberController login : "+memberdto);
			MemberDto memberDto = memberService.login(memberdto);
			if(memberDto != null) {
				model.addAttribute("chkLogin","1");
				session.setAttribute("session_id", memberDto.getId());
				session.setAttribute("session_name", memberDto.getName());
			}else {
				model.addAttribute("chkLogin","0");
			}
			return "login";
		}
	
	
	
	}
