package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Transactional
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	int rowPerPage = 10; //1페이지당 게시글 수
	
	@Override
	public Map<String, Object> blist(int page, String category, String searchW) {
		
		int count = boardMapper.countAll(category,searchW);
		
		int maxpage = (int)Math.ceil((double)count/rowPerPage); //마지막 페이지 개수
		int startpage = (int)((page-1)/10)*10+1; //첫번째 번호 넘버링
		int endpage = startpage+10-1; //마지막 번호 넘버링
		if(endpage>maxpage) endpage = maxpage; //맨 마지막에 끝 번호 처리(10번이 아니라 4번으로 끝나도록)
		int startrow = (page-1)*rowPerPage+1;  // 해당 번호의 첫번째 줄
		int endrow = startrow+rowPerPage-1;    // 해당 번호의 마지막 줄
		
		ArrayList<BoardDto> list = boardMapper.selectAll(startrow, endrow, category, searchW);
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("maxpage", maxpage);
		map.put("list", list);
		map.put("category", category);
		map.put("searchW", searchW);
		return map;
	}

	@Override
	public void bwrite(BoardDto bdto) {
		boardMapper.insertBoard(bdto);
		
	}

	@Override
	public Map<String, Object> bview(int bno) {
		
		Map<String, Object> map = new HashMap<>();
		
		boardMapper.updateBHit(bno);
//		System.out.println(10/0);
		BoardDto boardDto = boardMapper.selectOne(bno);
		
		BoardDto prevDto = boardMapper.selectOnePrev(bno);
		BoardDto nextDto = boardMapper.selectOneNext(bno);
		
//		System.out.println("prevDto : "+prevDto.getBno());
//		System.out.println("NextDto : "+nextDto.getBno());
		
		map.put("boardDto",boardDto);
		map.put("prevDto",prevDto);
		map.put("nextDto",nextDto);
		
		return map;
	}

	@Override
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
		
	}

	@Override
	public BoardDto bupdate(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	@Override
	public void bupdate(BoardDto bdto) {
		boardMapper.updateBoard(bdto);
	}

	@Override
	public BoardDto breply(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		return bdto;
	}

	@Override
	public void breply(BoardDto bdto) {
		// 같은 그룹에서 부모보다 bstep보다 높은 게시글을 모두 +1 증가
		boardMapper.bstepUp(bdto);
		// 답변달기 저장
		boardMapper.insertBreply(bdto);
		
	}

	
}
