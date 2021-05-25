package com.koreait.board7.cmt;

import com.koreait.board7.board.BoardEntity;

public class BoardCmtDomain extends BoardCmtEntity {

	private String writerNm;
	
	public String getWriterNm() {
		return writerNm;
	}
	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}
}
