package com.bitc.team5.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.BoardDto;
import com.bitc.team5.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> noticeBoardList() throws Exception {
		
		return	boardMapper.noticeBoardList();
	}

	@Override
	public void noticeInsert(BoardDto board) throws Exception {
		
		boardMapper.noticeInsert(board);
		
	}

	@Override
	public BoardDto noticeBoardDetail(int seq) throws Exception {
		
		return boardMapper.noticeBoardDetail(seq);
	}

	@Override
	public void noticeDelete(int seq) throws Exception {
		boardMapper.noticeDelete(seq);
		
	}

	@Override
	public void noticeUpdate(BoardDto board) throws Exception {
		boardMapper.noticeUpdate(board);
		
	}

}
