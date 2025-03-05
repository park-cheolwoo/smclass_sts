package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		System.out.println("MemberServiceImpl id : "+mdto.getId());
//		MemberDto memberDto = memberMapper.selectLogin(mdto);
//		return memberDto;
		return null;
	}

	@Override
	public List<MemberDto> FindAll() {
		List<MemberDto> list = memberMapper.findAll();
		return list;
	}
}
