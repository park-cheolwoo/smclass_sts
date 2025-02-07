package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;




@Controller
public class FController {

	@Autowired HttpSession session;
	
	
	@GetMapping("/")
	public String index() {
		System.out.println("index페이지가 열립니다.");
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		System.out.println("member페이지가 열립니다.");
		return "member";
	}
	
	@PostMapping("/member") // 오버로딩 : 매개변수의 개수나 타입이 달라야함
	public ModelAndView member(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = ""; //게임,골프,수영
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby += hobbys[i];
			else hobby += ","+hobbys[i];
		}
		
		//model 사용
		//model.addAttribute("member",new MemberDto(id,pw,name,tel,gender,hobby));
		
		//ModelAndView 사용
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memInfo"); // memInfo 로 위치 설정
		mv.addObject("member",new MemberDto(id,pw,name,tel,gender,hobby));
		return mv;
	}
	
	
	
	@GetMapping("/login")
	public String login() {
		System.out.println("로그인 get방식");
		return "login";
	}
	
	@GetMapping("/memInfo") //회원정보
	public String memInfo() {
		return "memInfo";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		session.setAttribute("session_id", id);
		session.setAttribute("session_pw", pw);
		return "loginInfo";
		
//		model.addAttribute("id",id);
//		model.addAttribute("pw",pw);
//		return "loginInfo";
		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("loginInfo");
//		mv.addObject("id",id);
//		mv.addObject("pw",pw);
//		return mv;
	}
	
	@RequestMapping("/logout") // getMapping, postMapping 2개 모두 사용 가능
	public String logout() {
		session.invalidate();
		return "logout";
	}
	
	
	
	
}
