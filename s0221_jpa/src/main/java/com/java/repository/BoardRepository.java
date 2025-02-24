package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.dto.BoardDto;

@Repository
public interface BoardRepository extends JpaRepository<BoardDto, Integer> {

	// "aaa" 필터링
//	@Query(value="select * from boardDto where id=? order by bgroup desc, bstep asc",
//			nativeQuery = true)
//	List<BoardDto> findAll("aaa");
	// 로그인
//	@Query(value="select * from memberDto where id=? and pw=?",
//			nativeQuery = true)
//	Optional<MemberDto> findIdAndPw(String id, String pw); //Optional : 데이터가 1개인 경우
	@Query(value="select * from boardDto where id=? order by bgroup desc, bstep asc",
			nativeQuery = true)
	List<BoardDto> findAll();
}
