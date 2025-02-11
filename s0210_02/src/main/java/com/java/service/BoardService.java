package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {

	Map<String, Object> blist(int page, String category, String searchW);

	void bwrite(BoardDto bdto);

	Map<String, Object> bview(int bno);

	void bdelete(int bno);

	BoardDto bupdate(int bno);

	void bupdate(BoardDto bdto);

	BoardDto breply(int bno);

	void breply(BoardDto bdto);

}
