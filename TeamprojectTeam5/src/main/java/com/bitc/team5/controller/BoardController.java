package com.bitc.team5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.BoardDto;
import com.bitc.team5.service.board.BoardService;
import com.github.pagehelper.PageInfo;


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

	
	//자유게시판
	@RequestMapping(value="/freeboard",method=RequestMethod.GET)
	public ModelAndView freeBoardList() throws Exception{
	ModelAndView mv = new ModelAndView("/board/freeBoard");
	
	List<BoardDto> boardList = boardService.freeBoardList();
	mv.addObject("boardList",boardList);
	
	return mv;
	}
	
	//자유게시판 검색기능
	@ResponseBody
	@RequestMapping(value="/ajaxfreeboard",method=RequestMethod.GET)
	public Object ajaxFreeBoardList(@RequestParam(value = "keyword", required = false, defaultValue="") String keyword) throws Exception{
//		ModelAndView mv = new ModelAndView("/board/reviewBoard");
		List<BoardDto> boardList = null;
		
		if (keyword.equals("")) {
			boardList = boardService.freeBoardList();
		}
		else {
			boardList = boardService.SearchFreeBoardList(keyword);
		}
		
//		mv.addObject("boardList",boardList);
		
		return boardList;
	}
	//자유게시판 글 쓰기
	@RequestMapping(value="/freeboard/write",method=RequestMethod.GET)
	public String freeWrite() throws Exception{
		
		return "/board/freeWrite";
		
	}
	
	@RequestMapping(value="/freeboard/write", method=RequestMethod.POST)
	public String freeInsert(BoardDto board) throws Exception{
		boardService.freeInsert(board);
		
		return "redirect:/freeboard";
	}
	// 자유게시판 자세히 보기
	@RequestMapping(value= "/free/{board_seq}", method=RequestMethod.GET)
	public ModelAndView freeBoardDetail(@PathVariable("board_seq")int seq) throws Exception{
		ModelAndView mv = new ModelAndView("/board/freeDetail");
		
		BoardDto boardList = boardService.freeBoardDetail(seq);
		mv.addObject("boardList", boardList);
		
		return mv;
	}
	//자유게시판 삭제
	@RequestMapping(value = "/free/delete/{board_seq}", method=RequestMethod.DELETE)
	public String freeDelete(@PathVariable("board_seq") int seq) throws Exception{
		boardService.freeDelete(seq);
		
		return "redirect:/freeboard";
			
	}
	// 자유게시판 수정
	@RequestMapping(value = "/free/update/{board_seq}",method=RequestMethod.PUT)
	public String freeUpdate(BoardDto board) throws Exception{
		boardService.freeUpdate(board);
		
		return "redirect:/freeboard";
	}
	//후기 게시판 리스트보기
//	@RequestMapping(value="/reviewboard",method=RequestMethod.GET)
//	public ModelAndView reviewBoardList() throws Exception{
//		ModelAndView mv = new ModelAndView("/board/reviewBoard");
//		
//		List<BoardDto> boardList = boardService.reviewBoardList();
//		mv.addObject("boardList",boardList);
//		
//		return mv;
//	}
	
//	@RequestMapping(value="/reviewboard",method=RequestMethod.GET)
//	public ModelAndView reviewBoardList(@RequestParam(required = false, defaultValue= "1") int pageNum) throws Exception{
//		ModelAndView mv = new ModelAndView("/board/reviewBoard");
//		
//		
//		List<BoardDto> boardList = boardService.reviewBoardList();
//		mv.addObject("boardList",boardList);
//		
//		return mv;
//	}
	
	@RequestMapping(value="/reviewboard",method=RequestMethod.GET)
	public ModelAndView reviewBoardList(@RequestParam(required=false, defaultValue= "1", value="pageNum") int pageNum) throws Exception{
		ModelAndView mv = new ModelAndView("/board/reviewBoard");
		
		PageInfo<BoardDto> boardList = new PageInfo<>(boardService.reviewBoardList(pageNum), 5);
		
		mv.addObject("boardList",boardList);
		
		return mv;
	}
	
	//후기 게시판 검색기능
	@ResponseBody
	@RequestMapping(value="/ajaxReviewboard",method=RequestMethod.GET)
	public Object ajaxReviewBoardList(@RequestParam(value = "keyword", required = false, defaultValue="") String keyword, @RequestParam(value="keytype", required=false, defaultValue="") String keytype) throws Exception{
//		ModelAndView mv = new ModelAndView("/board/reviewBoard");
		List<BoardDto> boardList = null;
		
//		if (keyword.equals("") && keytype.equals("")) {
//			boardList = boardService.reviewBoardList();
//		}
//		else if (!keyword.equals("") && keytype.equals("")) {
//			boardList = boardService.SearchKeywordReviewBoardList(keyword);
//		}
//		else if (keyword.equals("") && !keytype.equals("")) {
//			boardList = boardService.SearchKeytypeReviewBoardList(keytype);
//		}
//		else {
//			boardList = boardService.SearchReviewBoardList(keyword, keytype);
//		}
		
//		mv.addObject("boardList",boardList);
		
		return boardList;
	}
	
	//후기 글쓰기
	@RequestMapping(value="/reviewboard/write", method=RequestMethod.GET)
	public String reviewWrite() throws Exception{
		return "/board/reviewWrite";
		
	}
	
	@RequestMapping(value="/reviewboard/write", method=RequestMethod.POST)
	public String reviewInsert(BoardDto board) throws Exception{
		boardService.reviewInsert(board);
	
		return "redirect:/reviewboard";
	}
	//후기 자세히보기
	@RequestMapping(value="/reviewboard/{board_seq}", method=RequestMethod.GET)
	public ModelAndView reviewDetail(@PathVariable("board_seq")int seq) throws Exception{
		ModelAndView mv = new ModelAndView("/board/reviewDetail");
		
		BoardDto boardList = boardService.reviewDetail(seq);
		mv.addObject("boardList", boardList);
		
		return mv;
		
	}
	//후기 삭제
	@RequestMapping(value="/review/delete/{board_seq}", method=RequestMethod.DELETE)
	public String reviewDelete(@PathVariable("board_seq") int seq) throws Exception {
		boardService.reviewDelete(seq);
		
		return "redirect:/reviewboard";
			
	}
	//후기 수정
	@RequestMapping(value="/review/update/{board_seq}", method=RequestMethod.PUT)
	public String reviewUpdate(BoardDto board) throws Exception{
		boardService.reviewUpdate(board);
		
		return "redirect:/reviewboard";
		
	}
	
	@RequestMapping(value = "/review/write", method = RequestMethod.GET)
	public String joinUser() throws Exception {
		return "/board/reviewWrite";
	}

}	