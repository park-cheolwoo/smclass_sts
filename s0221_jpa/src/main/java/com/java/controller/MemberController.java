package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member")
	public String member(MemberDto mdto) {
		memberService.save(mdto);
		return "redirect:/";
	}
	
	@GetMapping("/mlist")
	public String mlist(Model model) {
		List<MemberDto> list = memberService.findAll();
		model.addAttribute("list", list);
		return "mlist";
	}
	
	@GetMapping("/memInfo")
	public String membInfo(String id,Model model) {
		MemberDto memberDto = memberService.findById(id);
		model.addAttribute("mdto",memberDto);
		return "meminfo";
	}
	
	@GetMapping("/memUpdate")
	public String memUpdate(String id, Model model) {
		MemberDto memberDto = memberService.findById(id);
		model.addAttribute("mdto",memberDto);
		return "memUpdate";
	}
	
	@PostMapping("/memUpdate")
	public String memUpdate(MemberDto mdto, Model model) {
		MemberDto memberDto = memberService.findById(mdto.getId());
		memberDto.setName(mdto.getName());
		memberDto.setPw(mdto.getPw());
		memberDto.setPhone(mdto.getPhone());
		memberDto.setGender(mdto.getGender());
		memberDto.setHobby(mdto.getHobby());
		memberDto.setMdate(mdto.getMdate());
		memberService.save(mdto); // id가 존재하면 update 실행, id가 존재하지 않으면 save 실행
		model.addAttribute("mdto",memberDto);
		return "memUpdate";
	}
	
	@ResponseBody
	@PostMapping("/memDelete")
	public String memDelete(String id) {
		System.out.println("id : "+id);
		memberService.delete(id);
		return "1";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw) {
		MemberDto memberDto = memberService.findByIdAndPw(id,pw);
		if(memberDto != null) {
			System.out.println("로그인되었습니다.");
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/";
		}
		else {
			System.out.println("로그인이 되지 않았습니다.");
			
		}
		return "redirect:/login?loginChk=0";
	}
	
	
	
	
	
}
