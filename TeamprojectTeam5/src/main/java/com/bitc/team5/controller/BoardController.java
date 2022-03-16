package com.bitc.team5.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//	@RequestMapping(value="/freeboard",method=RequestMethod.GET)
//	public ModelAndView freeBoardList() throws Exception{
//	ModelAndView mv = new ModelAndView("/board/freeBoard");
//	
//	List<BoardDto> boardList = boardService.freeBoardList();
//	mv.addObject("boardList",boardList);
//	
//	return mv;
//	}
//	
//	//자유게시판 검색기능
//	@ResponseBody
//	@RequestMapping(value="/ajaxfreeboard",method=RequestMethod.GET)
//	public Object ajaxFreeBoardList(@RequestParam(value = "keyword", required = false, defaultValue="") String keyword) throws Exception{
////		ModelAndView mv = new ModelAndView("/board/reviewBoard");
//		List<BoardDto> boardList = null;
//		
//		if (keyword.equals("")) {
//			boardList = boardService.freeBoardList();
//		}
//		else {
//			boardList = boardService.SearchFreeBoardList(keyword);
//		}
//		
////		mv.addObject("boardList",boardList);
//		
//		return boardList;
//	}
	
	@RequestMapping(value="/freeboard",method=RequestMethod.GET)
	public ModelAndView freeBoardList(
			@RequestParam(required=false, defaultValue= "1", value="pageNum") int pageNum,
			@RequestParam(value = "keyword", required = false, defaultValue="") String keyword,
			@RequestParam(value="keytype", required=false, defaultValue="") String keytype
			) throws Exception{
		ModelAndView mv = new ModelAndView("/board/freeBoard");
		
		Map<String, String> boardOption = new HashMap<String, String>();
		boardOption.put("pageNum", String.valueOf(pageNum));
		boardOption.put("keyword", keyword);
		boardOption.put("keytype", keytype);
		
		mv.addObject("boardOption", boardOption);
		
		PageInfo<BoardDto> boardList; 
		
		if (keyword.equals("") && keytype.equals("")) {
			boardList = new PageInfo<>(boardService.freeBoardList(pageNum), 5);
		}
		else if (!keyword.equals("") && keytype.equals("")) {
			boardList = new PageInfo<>(boardService.SearchKeywordFreeBoardList(pageNum, keyword), 5);
		}
		else if (keyword.equals("") && !keytype.equals("")) {
			boardList = new PageInfo<>(boardService.SearchKeytypeFreeBoardList(pageNum, keytype), 5);
		}
		else {
			boardList = new PageInfo<>(boardService.SearchFreeBoardList(pageNum, keyword, keytype), 5);
		}
		
		mv.addObject("boardList", boardList);
		
		return mv;
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
	public ModelAndView reviewBoardList(
			@RequestParam(required=false, defaultValue= "1", value="pageNum") int pageNum,
			@RequestParam(value = "keyword", required = false, defaultValue="") String keyword,
			@RequestParam(value="keytype", required=false, defaultValue="") String keytype
			) throws Exception{
		ModelAndView mv = new ModelAndView("/board/reviewBoard");
		
		Map<String, String> boardOption = new HashMap<String, String>();
		boardOption.put("pageNum", String.valueOf(pageNum));
		boardOption.put("keyword", keyword);
		boardOption.put("keytype", keytype);
		
		mv.addObject("boardOption", boardOption);
		
		PageInfo<BoardDto> boardList; 
		
		if (keyword.equals("") && keytype.equals("")) {
			boardList = new PageInfo<>(boardService.reviewBoardList(pageNum), 5);
		}
		else if (!keyword.equals("") && keytype.equals("")) {
			boardList = new PageInfo<>(boardService.SearchKeywordReviewBoardList(pageNum, keyword), 5);
		}
		else if (keyword.equals("") && !keytype.equals("")) {
			boardList = new PageInfo<>(boardService.SearchKeytypeReviewBoardList(pageNum, keytype), 5);
		}
		else {
			boardList = new PageInfo<>(boardService.SearchReviewBoardList(pageNum, keyword, keytype), 5);
		}
		
		mv.addObject("boardList", boardList);
		
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/reviewboard/write1", method = RequestMethod.POST)
	public Object box1Selected(@RequestParam("type") String type) throws Exception {
		List<String> place = new ArrayList<String>();
		if(type.equals("숙박")) {
			place.add("대성장");
			place.add("파라다이스호텔 부산");
			place.add("G2모텔");
			place.add("이비스앰배서더호텔 부산시티센터점");
			
		}else if(type.equals("명소")) {
			place.add("암남공원");
			place.add("시민공원");
			place.add("UN기념공원");
			place.add("용두산공원");
			place.add("삼락생태공원");
			place.add("광안대교");
			place.add("해운대 달맞이 길");
			place.add("송도 해상 케이블 카");
			place.add("BIFF 광장");
			place.add("서면 먹자 골목");
			place.add("흰여울문화마을");
			place.add("민락수변공원");
			place.add("동백섬");
			place.add("청사포 다릿돌 전망대");
			place.add("이기대 해안산책로");
			place.add("감천 문화마을");
			place.add("자갈치시장");
			place.add("국제시장");
			place.add("부전시장");
			place.add("기장시장");
			
		}
		return place;
	}
	
	//후기 게시판 검색기능
	@ResponseBody
	@RequestMapping(value="/ajaxReviewboard",method=RequestMethod.GET)
	public Object ajaxReviewBoardList(@RequestParam(value = "keyword", required = false, defaultValue="") String keyword, @RequestParam(value="keytype", required=false, defaultValue="") String keytype) throws Exception{
		List<BoardDto> boardList = null;
		
//		if (keyword.equals("") && keytype.equals("")) {
//			boardList = boardService.reviewBoardList(0);
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