package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {

	@Autowired BoardService boardService;
	
	@GetMapping("/board/blist")
	public String blist(@RequestParam (value="page",defaultValue="1") int page, String category, String searchW, Model model) {
		System.out.println("category : "+category);
		System.out.println("searchW : "+searchW);
		
		
		Map<String, Object> map = boardService.blist(page,category, searchW);
		model.addAttribute("page",map.get("page"));
		model.addAttribute("maxpage",map.get("maxpage"));
		model.addAttribute("startpage",map.get("startpage"));
		model.addAttribute("endpage",map.get("endpage"));
		model.addAttribute("list",map.get("list"));
		model.addAttribute("searchW",map.get("searchW"));
		model.addAttribute("category",map.get("category"));
		return "blist";
	}
	
	@GetMapping("/board/bwrite")
	public String bwrite() { // bno가 넘어오지 않아도 에러가 생기지 않음
		return "bwrite";
	}

	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto bdto, @RequestPart MultipartFile files) throws Exception {
		
		bdto.setBfile(""); //파일첨부가 되지 않았을 경우
		if(!files.isEmpty()) {
			String origin = files.getOriginalFilename(); // r01.jpg
			long time = System.currentTimeMillis();
			String realFileName = String.format("%d_%s",time,origin);
			String url = "c:/upload/board/";
			File f= new File(url+realFileName);
			files.transferTo(f);
			bdto.setBfile(realFileName);
		}
		
		
		
		
		
		boardService.bwrite(bdto);
		return "redirect:/?chkBwirte=1";
	}
	
	@GetMapping("/board/bview") 
	public String bview(@RequestParam(defaultValue="1") int bno, int page, Model model) {
		Map<String, Object> map = boardService.bview(bno);
		model.addAttribute("bDto",map.get("boardDto"));
		model.addAttribute("pDto",map.get("prevDto"));
		model.addAttribute("nDto",map.get("nextDto"));
		model.addAttribute("page",page);
		return "bview";
	}
	
	@GetMapping("/board/bdelete") 
	public String bdelete(int bno, int page, Model model) {
		boardService.bdelete(bno);
		return "redirect:/board/blist?page="+page;
	}
	
	@GetMapping("/board/bupdate") 
	public String bupdate(int bno, int page, Model model) {
		BoardDto boardDto = boardService.bupdate(bno);
//		boardService.bdelete(bno);
		model.addAttribute("bDto",boardDto);
		model.addAttribute("page",page);
		return "bupdate";
	}
	
	
	@PostMapping("/board/bupdate")
	public String bupdate(BoardDto bdto, int page, Model model) {
		model.addAttribute("page",page);
		boardService.bupdate(bdto);
		return "redirect:/board/blist?page="+page;
	}
	
	
	@GetMapping("/board/breply") 
	public String breply(int bno, int page, Model model) {
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("bdto",boardDto);
		model.addAttribute("page",page);
		return "breply?page="+page;
	}
	
	@PostMapping("/board/breply")
	public String breply(BoardDto bdto, int page, Model model) {
		boardService.breply(bdto);
		model.addAttribute("page",page);
		return "redirect:/board/blist?page="+page;
	}
	
	
	
	
	
	
}
