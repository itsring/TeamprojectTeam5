package com.bitc.team5.dto;

import lombok.Data;

@Data
public class BoardDto {

	private int boardSeq;
	private String boardTitle;
	private String boardContent;
	private String category;
	private String userName;
	
	private String place;
	private String star;
	private String type;
	private String keyword;
}
