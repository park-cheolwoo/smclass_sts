package com.java.dao;


import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto login(String id, String pw);
}
