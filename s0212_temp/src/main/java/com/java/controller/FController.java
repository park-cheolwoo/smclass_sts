package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
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
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto bdto, @RequestPart MultipartFile files) {
		String real_fname="";
		if(!files.isEmpty()) {
			String origin_fname = files.getOriginalFilename();
			System.out.println("최초 파일 이름 : "+origin_fname);
			UUID uuid = UUID.randomUUID();
			String uname = uuid+"_"+origin_fname;
			long time = System.currentTimeMillis();
			real_fname = String.format("%d_%s",time, origin_fname);
			System.out.println("실제 파일 이름 : "+real_fname);
			String url = "C:/upload/board/";
			File f = new File(url+real_fname);
			
			try {
				files.transferTo(f);
				bdto.setBfile(real_fname);
			} catch (Exception e) {e.printStackTrace();}
		
		}else {bdto.setBfile("");}
		boardService.bwrite(bdto);
		
		
		return "redirect:/board/blist";
	}
	
	
}
