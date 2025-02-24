package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.MemberDto;

//JpaRepository<MemberDto, String> : <리턴타입, key타입>
public interface MemberRepository extends JpaRepository<MemberDto, String> {

	//select * from memberdto where id=#{id} and pw=#{pw}
	MemberDto findByIdAndPw(String id, String pw);

	// 로그인
//		@Query(value="select * from memberDto where id=? and pw=?",
//				nativeQuery = true)
//		MemberDto findIdAndPw(String id, String pw);
}
