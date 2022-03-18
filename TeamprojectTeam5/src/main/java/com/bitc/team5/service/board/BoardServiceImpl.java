package com.bitc.team5.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.BoardDto;
import com.bitc.team5.dto.HotDto;
import com.bitc.team5.dto.LodgeListDto;
import com.bitc.team5.mapper.BoardMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	//공지
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

	// 자유
//	@Override
//	public List<BoardDto> freeBoardList() throws Exception {
//
//		return boardMapper.freeBoardList();
//	}
	@Override
	public Page<BoardDto> freeBoardList(int pageNum) throws Exception {
		PageHelper.startPage(pageNum, 10);
		return boardMapper.freeBoardList(pageNum);
	}
	
//	자유게시판 검색기능

	@Override
	public Page<BoardDto> SearchKeywordFreeBoardList(int pageNum, String keyword) throws Exception {
		PageHelper.startPage(pageNum, 10);
		
		return boardMapper.SearchKeywordFreeBoardList(keyword);
	}

	@Override
	public Page<BoardDto> SearchKeytypeFreeBoardList(int pageNum, String keytype) throws Exception {
		PageHelper.startPage(pageNum, 110);
		return boardMapper.SearchKeytypeFreeBoardList(keytype);
	}

	@Override
	public Page<BoardDto> SearchFreeBoardList(int pageNum, String keyword, String keytype) throws Exception {
		PageHelper.startPage(pageNum, 10);

		return boardMapper.SearchFreeBoardList(keyword, keytype);
	}

//	@Override
//	public List<BoardDto> SearchFreeBoardList(String keyword) throws Exception {
//		return boardMapper.SearchFreeBoardList(keyword);
//	}
//	
	@Override
	public void freeInsert(BoardDto board) throws Exception {
		boardMapper.freeInsert(board);
		
	}

	@Override
	public BoardDto freeBoardDetail(int seq) throws Exception {
		return boardMapper.freeBoardDetail(seq);
	}

	@Override
	public void freeDelete(int seq) throws Exception {
		boardMapper.freeDelete(seq);		
	}

	@Override
	public void freeUpdate(BoardDto board) throws Exception {
		boardMapper.freeUpdate(board);
		
		
	}

	// 후기
//	@Override
//	public List<BoardDto> reviewBoardList() throws Exception {
//
//		return boardMapper.reviewBoardList();
//	}
	
	@Override
	public Page<BoardDto> reviewBoardList(int pageNum) throws Exception {
		PageHelper.startPage(pageNum, 10);
		return boardMapper.reviewBoardList();
	}
	
//	@Override
//	public List<BoardDto> SearchReviewBoardList(String keyword, String keytype) throws Exception {
//		return boardMapper.SearchReviewBoardList(keyword, keytype);
//	}

	@Override
	public void reviewInsert(BoardDto board) throws Exception {

		boardMapper.reviewInsert(board);
	}

	@Override
	public BoardDto reviewDetail(int seq) throws Exception {

		return boardMapper.reviewDetail(seq);
	}

	@Override
	public void reviewDelete(int seq) throws Exception {
	
		boardMapper.reviewDelete(seq);
	}

	@Override
	public void reviewUpdate(BoardDto board) throws Exception {

		boardMapper.reviewUpdate(board);
	}

//	@Override
//	public List<BoardDto> SearchKeywordReviewBoardList(String keyword) throws Exception {
//		return boardMapper.SearchKeywordReviewBoardList(keyword);
//	}
//
//	@Override
//	public List<BoardDto> SearchKeytypeReviewBoardList(String keytype) throws Exception {
//		return boardMapper.SearchKeytypeReviewBoardList(keytype);
//	}

//	public Page<BoardDto> reviewBoardList(int pageNum) throws Exception {
//	PageHelper.startPage(pageNum, 5);
//	return boardMapper.reviewBoardList();
//}
	
	@Override
	public Page<BoardDto> SearchKeywordReviewBoardList(int pageNum, String keyword) throws Exception {
		PageHelper.startPage(pageNum, 110);
		return boardMapper.SearchKeywordReviewBoardList(keyword);
	}

	@Override
	public Page<BoardDto> SearchKeytypeReviewBoardList(int pageNum, String keytype) throws Exception {
		PageHelper.startPage(pageNum, 10);
		return boardMapper.SearchKeytypeReviewBoardList(keytype);
	}

	@Override
	public Page<BoardDto> SearchReviewBoardList(int pageNum, String keyword, String keytype) throws Exception {
		PageHelper.startPage(pageNum, 10);
		return boardMapper.SearchReviewBoardList(keyword, keytype);
	}

	@Override
	public List<LodgeListDto> lodgeList() throws Exception {
		
		return boardMapper.lodgeList();
	}

	@Override
	public List<HotDto> hotPlaceList() throws Exception {
		return boardMapper.hotPlaceList();
	}

}
