package com.java.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java.dto.MemberDto;
import com.java.dao.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper mMapper;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		MemberDto member = mMapper.login(mdto.getId(),mdto.getPw());
		return member;
	}

}
