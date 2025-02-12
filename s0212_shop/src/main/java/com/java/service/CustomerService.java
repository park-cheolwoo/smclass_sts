package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface CustomerService {

	ArrayList<BoardDto> notice();

	Map<String, Object> nview(int bno);

	

}
