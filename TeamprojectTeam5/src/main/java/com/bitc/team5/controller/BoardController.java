package com.bitc.team5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.BoardDto;
import com.bitc.team5.service.board.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//게시판 선택 페이지
	@RequestMapping(value="/board")
	public String boardList() throws Exception{
		return "/board/boardSelect";
	}
	
	//공지사항리스트 보기
	@RequestMapping(value="/notice",method=RequestMethod.GET)
	public ModelAndView noticeBoardList() throws Exception{
	ModelAndView mv = new ModelAndView("/board/noticeBoard");
	
	List<BoardDto> boardList = boardService.noticeBoardList();
	mv.addObject("boardList",boardList);
	
	return mv;
	}
	// 공지사항 작성
	@RequestMapping(value="/notice/write",method=RequestMethod.GET)
	public String noticeWrite() throws Exception{
		return "/board/noticeWrite";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.POST)
	public String noticeInsert(BoardDto board) throws Exception{
		boardService.noticeInsert(board);
		
		return "redirect:/notice";
	}
	//공지사항 자세히보기
	@RequestMapping(value= "/notice/{board_seq}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("board_seq")int seq) throws Exception{
		ModelAndView mv = new ModelAndView("/board/noticeDetail");
		
		BoardDto boardList = boardService.noticeBoardDetail(seq);
		mv.addObject("boardList", boardList);
		
		return mv;
	}
	//공지사항 삭제
	@RequestMapping(value="/notice/delete/{board_seq}",method=RequestMethod.DELETE)
	public String noticeDelete(@PathVariable("board_seq") int seq) throws Exception{
		boardService.noticeDelete(seq);
		return "redirect:/notice";
		
	}
	
	//공지사항 수정
	@RequestMapping(value="/notice/update/{board_seq}",method=RequestMethod.PUT)
	public String noticeUpdate(BoardDto board) throws Exception{
		boardService.noticeUpdate(board);
		
		return "redirect:/notice";
	}

	
//	//자유게시판
//	@RequestMapping(value="/freeboard",method=RequestMethod.GET)
//	public ModelAndView freeBoardList() throws Exception{
//	ModelAndView mv = new ModelAndView("/board/freeBoard");
//	
//	List<BoardDto> boardList = boardService.selectBoardList();
//	mv.addObject("boardList",boardList);
//	
//	return mv;
//	}
//	
}