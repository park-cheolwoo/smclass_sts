package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}
	
	@GetMapping("/member/login")
	public String login(HttpServletResponse response) {
//		Cookie cookie = new Cookie("cook_id","aaa");
//		cookie.setMaxAge(60*60*24);
//		response.addCookie(cookie);
//		
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberDto mdto, Model model) {
		System.out.println("controller id : "+mdto.getId());
		MemberDto memberDto = memberService.login(mdto);
		if(memberDto!=null) {
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/?loginChk=1";
		}else {
			model.addAttribute("loginChk",0);
			return "member/login";
		}
	}

	@GetMapping("/member/step01")
	public String step01() {
		return "member/step01";
	}
	
	@GetMapping("/member/step02")
	public String step02() {
		session.removeAttribute("pwCode");
		return "member/step02";
	}
	
	@ResponseBody
	@PostMapping("/member/sendEmail")
	public String sendEmail(String email) {
		System.out.println("sendEmail : "+email);
		String pwcode = memberService.sendEmail(email);
		session.setAttribute("pwCode", pwcode);
		return pwcode;
	}
	
	@ResponseBody
	@PostMapping("/member/sendEmail2")
	public String sendEmail2(String email) {
		System.out.println("sendEmail : "+email);
		String pwcode = memberService.sendEmail2(email);
				
		return pwcode;
		
	}
	
	@ResponseBody
	@PostMapping("/member/pwCodeCheck")
	public String pwCodeCheck(String pwCode) {
		System.out.println("pwCodeCheck pwCode : "+pwCode);
		String pw = (String)session.getAttribute("pwCode");
		if(pwCode.equals(pw)) {return "1";} else {return "0";}
		
	}
	
	
	
	
}
