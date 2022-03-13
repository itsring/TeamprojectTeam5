package com.bitc.team5.service.board;

import java.util.List;

import com.bitc.team5.dto.BoardDto;
import com.github.pagehelper.Page;

public interface BoardService {

	//공지
	List<BoardDto> noticeBoardList() throws Exception;

	void noticeInsert(BoardDto board) throws Exception;

	BoardDto noticeBoardDetail(int seq) throws Exception;

	void noticeDelete(int seq) throws Exception;

	void noticeUpdate(BoardDto board) throws Exception;

	// 자유
	List<BoardDto> freeBoardList() throws Exception;

	void freeInsert(BoardDto board) throws Exception;

	BoardDto freeBoardDetail(int seq) throws Exception;

	void freeDelete(int seq) throws Exception;

	void freeUpdate(BoardDto board) throws Exception;

	List<BoardDto> SearchFreeBoardList(String keyword) throws Exception;

	// 후기
//	List<BoardDto> reviewBoardList() throws Exception;
	Page<BoardDto> reviewBoardList(int pageNum) throws Exception;
	
	List<BoardDto> SearchReviewBoardList(String keyword, String keytype) throws Exception;

	void reviewInsert(BoardDto board) throws Exception;

	BoardDto reviewDetail(int seq) throws Exception;

	void reviewDelete(int seq) throws Exception;

	void reviewUpdate(BoardDto board) throws Exception;

	List<BoardDto> SearchKeywordReviewBoardList(String keyword) throws Exception;

	List<BoardDto> SearchKeytypeReviewBoardList(String keytype) throws Exception;

}
