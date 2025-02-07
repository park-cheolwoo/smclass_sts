package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.StuDto;
import com.java.dto.memDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;
import com.java.service.BServiceImpl3;
import com.java.service.BServiceImpl4;


@Controller
public class FController {
	
	//객체선언
	@Autowired	BService b;
	

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	// 매개변수로 전달받음
//	@PostMapping("/member")
//	public String member(String id, String pw, String name, String tel, String gender, String[] hobby, Model model) {
//		String hobby2 = "";
//		for(int i=0;i<hobby.length;i++) {
//			if(i==0) hobby2 += hobby[0];
//			else hobby2 += ","+hobby[i];
//		}
//		memDto m = new memDto(id,pw,name,tel,gender,hobby2);
//		model.addAttribute("mem",m);
//		return "memInfo";
//	}
	
	@PostMapping("/member")
	public String memInfo(memDto mDto, Model model) {
		System.out.println("mDto id : "+mDto.getId());
		System.out.println("mDto hobby : "+mDto.getHobby()); // checkbox 객체를 자동으로 형변환해서 String으로 변환해줌
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
	public String stuInput(StuDto sDto, Model model) {
		sDto.setTotal(sDto.getKor()+sDto.getEng()+sDto.getMath());
		sDto.setAvg(sDto.getTotal()/3.0);
		model.addAttribute("stu",sDto);
		return "stuInfo";
	}
	
	@GetMapping("/stuInfo")
	public String stuInfo() {
		return "stuInfo()";
	}
	
	@GetMapping("/data")
	public String data(@RequestParam(defaultValue="1")int bno,Model model) {
		model.addAttribute("bno",bno);
		return "data";
	}
	
	@GetMapping("/data2/{bno}") // pathVariable 방식
	public String data2(@PathVariable int bno,Model model) {
		model.addAttribute("bno",bno);
		return "data2";
	}
	
	@GetMapping("/data3/{bno}") // pathVariable 방식
	public String data3(@PathVariable List<Integer> bno,Model model) {
		model.addAttribute("bno",bno);
		return "data3";
	}
	
	@GetMapping("/data4") 
	public String data4() {
		String str = b.slist();
		System.out.println("str : "+str);
		return "data4";
	}
	
}
