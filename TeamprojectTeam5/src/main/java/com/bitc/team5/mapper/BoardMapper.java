package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> noticeBoardList() throws Exception;

	void noticeInsert(BoardDto board) throws Exception;

	BoardDto noticeBoardDetail(int seq) throws Exception;

	void noticeDelete(int seq) throws Exception;

	void noticeUpdate(BoardDto board) throws Exception;

}
