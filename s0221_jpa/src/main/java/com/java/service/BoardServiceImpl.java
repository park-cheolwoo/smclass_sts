package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardRepository boardRepository;

	@Override
	public List<BoardDto> findAll() {
		// 1. 다중정렬을 사용해서 검색
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
//				); // Sort : data.domain.sort
//		List<BoardDto> list = boardRepository.findAll(sort); // jpa는 자기가 알아서 가져옴, 정렬이 안되있는 상태
		List<BoardDto> list = boardRepository.findAll(); // jpa는 자기가 알아서 가져옴, 정렬이 안되있는 상태
		return list;
	}

	@Override
	public BoardDto findById(int bno) {
		BoardDto boardDto = boardRepository.findById(bno).orElseThrow(
				() -> {
					return new IllegalArgumentException("데이터 처리시 에러!");	
				}
				);
		return boardDto;
	}

}
