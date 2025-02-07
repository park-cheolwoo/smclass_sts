package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

// @Repository - Dao

@Mapper
public interface BMapper {

	ArrayList<BoardDto> blist();
}
