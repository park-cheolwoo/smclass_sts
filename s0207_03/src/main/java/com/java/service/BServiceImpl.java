package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapping;
import com.java.dto.BoardDto;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BoardMapping boardMapping;
	
	@Override
	public ArrayList<BoardDto> blist(){
		System.out.println("BoardMapping : 정상");
		ArrayList<BoardDto> list = boardMapping.blist();
		System.out.println("SQL : 정상");
		return list;
	}
	
}
