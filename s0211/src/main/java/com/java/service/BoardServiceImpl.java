package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper bMapper;
	int rowsPerPage = 10;
	
	public Map<String,Object> blist(int page){
		int rows = bMapper.countAll();
		int maxPage = (int)Math.ceil(rows/(double)rowsPerPage); // 총 페이지 개수(겸 끝 페이지)
		int startNum = ((page-1)/rowsPerPage)*rowsPerPage+1; //페이지의 시작번호
		int endNum = startNum+rowsPerPage-1; //페이지의 마지막 번호
		ArrayList<BoardDto> list = bMapper.selectAll(startNum,endNum);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("page", page);
		map.put("maxPage", maxPage);
		System.out.println("시작 : "+startNum+" / 종료 : "+endNum);
		return map;
	};
}
