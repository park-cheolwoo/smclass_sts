package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	int countAll();

	ArrayList<BoardDto> selectAll(int startNum, int endNum);

}
