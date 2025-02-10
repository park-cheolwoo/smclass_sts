package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> selectAll();

	void insertBoard(BoardDto bdto);

	BoardDto selectOne(int bno);

	void updateBHit(int bno);

	void deleteBoard(int bno);

}
