package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.dto.MemberDto;

public interface MemberMapper extends JpaRepository<MemberDto, String> {

	


}
