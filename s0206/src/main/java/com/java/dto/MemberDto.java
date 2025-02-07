package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor 	// 기본생성자
@AllArgsConstructor // 전체생성자
@Data 				//getter,setter
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	
	public String getId() {
		return id;
	}
}

