package com.bitc.team5.service.board;

import java.util.List;

import com.bitc.team5.dto.BoardDto;

public interface BoardService {

	List<BoardDto> noticeBoardList() throws Exception;

	void noticeInsert(BoardDto board) throws Exception;

	BoardDto noticeBoardDetail(int seq) throws Exception;

	void noticeDelete(int seq) throws Exception;

	void noticeUpdate(BoardDto board) throws Exception;

}
