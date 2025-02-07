package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class FController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@GetMapping("/board")
	public String board(int bno, String btitle, Model model) {
		System.out.println("bno : "+bno);
		System.out.println("btitle : "+btitle);
		model.addAttribute("bno",bno);
		model.addAttribute("btitle",btitle);
		return "board";
	}
	
	@PostMapping("/stuInput")
	public String stuInput(HttpServletRequest request, int stuno, String name, int kor, int eng, int math, Model model) {
		int total = kor+eng+math;
		double avg = total/3.0;
		StuDto s = StuDto.builder().stuno(stuno).name(name).kor(kor).eng(eng).math(math).total(total).avg(avg).build();
		model.addAttribute("stu",s);
	
		return "stuInfo";
	}
	
	@GetMapping("/stuInfo")
	public String stuInfo() {
		return "stuInfo";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,
			@RequestParam("id") String id, //form name="id" 데이터 가져옴
			@RequestParam(required=false) String pw, //null값 허용
			String name ,//@RequestParam 생략 가능, form 이름과 같아야함
			@RequestParam int kor,
			@RequestParam(defaultValue = "0") int eng, // 값이 없을 경우 0으로 세팅
			int math,
			Model model) {
		//RequestParam : request에서 그대로 변수를 받아옴, 자동 형변환
		//post의 name과 RequestParam의 변수명이 같아야함. 다를 경우 id의 경우처럼 작성
		int total = kor+eng+math;
		double avg = total/3.0;
		
		
		
//		String aid = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String akor = request.getParameter("kor");
//		String aeng = request.getParameter("eng");
//		String amath = request.getParameter("math");
//		int total = Integer.parseInt(kor)+Integer.parseInt(eng)+Integer.parseInt(math);
//		double avg = (total/3.0);
		System.out.println("데이터 id : "+id+", pw : "+pw);
		model.addAttribute("mem", MemDto.builder().id(id).pw(pw).name("홍길동").build());
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("math",math);
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
		
		MemDto m = new MemDto();
		MemDto m1 = MemDto.builder().id("bbb").pw("2222").build();
		
		return "loginInfo";
	}
	
}
