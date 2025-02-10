package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	public ArrayList<BoardDto> blist();
	
	public void boardWrite(BoardDto bdto);
}
