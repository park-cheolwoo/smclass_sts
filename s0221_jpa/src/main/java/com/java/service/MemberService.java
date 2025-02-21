package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	void save(MemberDto mdto);

	List<MemberDto> findAll();

	MemberDto findById(String id);

	void delete(String id);

	MemberDto findByIdAndPw(String id, String pw);

}
