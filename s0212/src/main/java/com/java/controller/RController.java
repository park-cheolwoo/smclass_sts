package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@RestController
public class RController {
	
	@Autowired BoardService boardService;

	@GetMapping("/restpage")
	public ArrayList<BoardDto> restpage() {
			ArrayList<BoardDto> list = boardService.blist();
			return list;
		}
		
		
		
		
		
	}

