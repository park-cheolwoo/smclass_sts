package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
	private int bno;
	private String btitle;
	private String bcontent;
	private String id;
	private int bgroup;
	private int bindent;
	private int bstep;
	private int bhit;
	private Timestamp bdate;
}
