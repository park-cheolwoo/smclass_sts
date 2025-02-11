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

	@Autowired MemberService mService;
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberDto mdto, Model model) {
		MemberDto member = mService.login(mdto);
		if(member != null) {
			model.addAttribute("chkLogin","1");
			session.setAttribute("session_id", member.getId());
			session.setAttribute("session_name", member.getName());
		}else {
			model.addAttribute("chkLogin","0");
		}
		return "login";
	}
	
	@GetMapping("/member/logout")
	public String logout(Model model) {
		session.invalidate();
		return "redirect:/?chkLogout=1";
	}
	
	
}
