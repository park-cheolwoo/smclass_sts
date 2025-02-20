package com.java.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;


@Controller
public class FController {
	
	@Autowired BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	@ResponseBody
	@PostMapping("/summernoteUpload")
	public String bwrite_upload(@RequestParam MultipartFile file) throws Exception {
		System.out.println("summernoteUpload 호출");
		String realFileName="";
		if(!file.isEmpty()) {
			String origin = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			realFileName = String.format("%d_%s",time,origin);
			String url = "c:/upload/board/";
			File f = new File(url+realFileName);
			file.transferTo(f);
		}
		System.out.println("링크파일 주소  : "+"/upload/board/"+realFileName);
		return "/upload/board/"+realFileName;
	}
	
	
	
	
	@PostMapping("/bwrite")
	public String bwirte(BoardDto bdto, @RequestParam MultipartFile file) throws Exception {
		String realFileName="";
		bdto.setBfile("");
		if(!file.isEmpty()) {
			String origin = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			realFileName = String.format("%d_%s",time,origin);
			String url = "c:/upload/board/";
			File f = new File(url+realFileName);
			file.transferTo(f);
			bdto.setBfile(realFileName);
		}
		boardService.bwrite(bdto);
		System.out.println("bcontent : "+bdto.getBcontent());
		System.out.println("bfile : "+bdto.getBfile());
		System.out.println("파일첨부 글쓰기 완료");
		return "redirect:/";
	}
	
	@GetMapping("/board/bview")
	public String bview(int bno, Model model) {
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("bdto",boardDto);
		return "bview";
	}

}
