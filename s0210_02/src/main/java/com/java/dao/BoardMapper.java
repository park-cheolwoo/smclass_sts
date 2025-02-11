package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> selectAll(int startrow, int endrow, String category, String searchW);

	void insertBoard(BoardDto bdto);

	BoardDto selectOne(int bno);

	void updateBHit(int bno);

	void deleteBoard(int bno);

	void updateBoard(BoardDto bdto);

	void bstepUp(BoardDto bdto);

	void insertBreply(BoardDto bdto);

	BoardDto selectOnePrev(int bno);

	BoardDto selectOneNext(int bno);

	int countAll(String category, String searchW);

}
