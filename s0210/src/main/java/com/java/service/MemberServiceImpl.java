package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	@Override
	public MemberDto login(String id, String pw) {
		System.out.println("Service 호출");
		MemberDto memberDto = memberMapper.selectLogin(id,pw);
		return memberDto;
	}
	
	@Override
	public void member(MemberDto mdto) {
//		int result = memberMapper.insertMember(mdto);
//		System.out.println("결과 : "+result);
		memberMapper.insertMember(mdto);
	}
}
