package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired HttpSession session;
	
	@GetMapping("/login")
	public String login(String chk) {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, Model model) {
		
		// db 접근해서 id,pw가 맞는지 확인
		if(id.equals("aaa") && pw.equals("1111")) {
			session.removeAttribute("logoutChk"); //세션 1개 삭제
			session.setAttribute("session_id", id);
			session.setAttribute("loginChk", 1);
			return "redirect:/?chk=1"; //jsp페이지를 호출
		}else {
			model.addAttribute("chk","0");
			return "redirect:/member/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 세션 모두 삭제
		session.setAttribute("logoutChk", 1);
		return "redirect:/?outChk=1";
	}
	
	
	
	
}
