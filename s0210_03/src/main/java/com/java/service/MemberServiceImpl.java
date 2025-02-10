package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper mMapper;

	@Override
	public MemberDto login(MemberDto mdto) {
		MemberDto member = mMapper.login(mdto);
		return member;
	}

}
