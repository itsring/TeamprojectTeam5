package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team5.dto.BoardDto;
import com.github.pagehelper.Page;

@Mapper
public interface BoardMapper {
	//공지 게시판
	List<BoardDto> noticeBoardList() throws Exception;

	void noticeInsert(BoardDto board) throws Exception;

	BoardDto noticeBoardDetail(int seq) throws Exception;

	void noticeDelete(int seq) throws Exception;

	void noticeUpdate(BoardDto board) throws Exception;

	//자유 게시판
	List<BoardDto> freeBoardList() throws Exception;
	//자유 게시판 검색기능
	List<BoardDto> SearchFreeBoardList(String keyword) throws Exception;

	void freeInsert(BoardDto board) throws Exception;

	BoardDto freeBoardDetail(int seq) throws Exception;

	void freeDelete(int seq) throws Exception;

	void freeUpdate(BoardDto board) throws Exception;
	
	//후기 게시판
//	List<BoardDto> reviewBoardList() throws Exception;
	Page<BoardDto> reviewBoardList() throws Exception;
	
	List<BoardDto> SearchReviewBoardList(@Param("keyword") String keyword, @Param("keytype") String keytype) throws Exception;

	void reviewInsert(BoardDto board) throws Exception;

	BoardDto reviewDetail(int seq) throws Exception;

	void reviewDelete(int seq) throws Exception;

	void reviewUpdate(BoardDto board) throws Exception;

	void getSearchList(BoardDto board) throws Exception;

	List<BoardDto> SearchKeywordReviewBoardList(String keyword) throws Exception;

	List<BoardDto> SearchKeytypeReviewBoardList(String keytype) throws Exception;

}
