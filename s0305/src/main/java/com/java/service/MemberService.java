package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	List<MemberDto> FindAll();

	MemberDto login(MemberDto mdto);

	
	
	
}
