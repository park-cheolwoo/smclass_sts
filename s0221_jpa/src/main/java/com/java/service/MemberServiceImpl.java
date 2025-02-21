package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override
	public void save(MemberDto mdto) {
		memberRepository.save(mdto);
		
	}

	@Override
	public List<MemberDto> findAll() {
		List<MemberDto> list = memberRepository.findAll();
		return list;
	}

	// select * from memberdto where id = #{id}
	// findByIdAndPw -> select * from memberdto where id=#{id} and pw=#{pw}
	@Override
	public MemberDto findById(String id) {
		// findById -> 검색이 없을 경우 에러처리를 해야함
		MemberDto memberDto = memberRepository.findById(id)
				.orElseThrow(()->{return new IllegalArgumentException("데이터 처리시 에러");});
		return memberDto;
	}

	@Override
	public void delete(String id) {
		memberRepository.deleteById(id);
		
	}

	@Override
	public MemberDto findByIdAndPw(String id, String pw) {
		MemberDto memberdto = memberRepository.findByIdAndPw(id,pw);
		return memberdto;
	}

}
