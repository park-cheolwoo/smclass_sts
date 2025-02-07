package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.StuDto;


public class BServiceImpl3 implements BService {
	public String slist() {
		ArrayList<StuDto> list = new ArrayList<StuDto>();
		return "stu여러개보냄3";
	}
}
