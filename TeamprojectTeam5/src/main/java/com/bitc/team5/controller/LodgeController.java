package com.bitc.team5.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.LodgeDto;
import com.bitc.team5.dto.LodgeListDto;
import com.bitc.team5.dto.LodgeRoomDto;
import com.bitc.team5.service.lodge.LodgeService;

@Controller
public class LodgeController {
	
	@Autowired
	private LodgeService lodgeService;
	
	/* 명소별 제휴 숙소 목록*/
	 @RequestMapping(value="/lodge/lodgeList", method=RequestMethod.GET) 
	 public ModelAndView lodgeList() throws Exception {
	 	ModelAndView mv = new ModelAndView("lodge/lodgeList");
	  
		 List<LodgeListDto> lodgeList = lodgeService.selectLodgeList();
		 mv.addObject("lodgeList", lodgeList);
		 
		 return mv; 
	}
	
	 
	 /* 숙소 예약 상세*/
	@RequestMapping(value="/lodge/lodgeListBook/{seq}", method=RequestMethod.GET) 
	public ModelAndView lodgeDetail(@PathVariable("seq") int seq, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("lodge/lodgeLIstBook");
		
		LodgeListDto lodgeDetail = lodgeService.lodgeDetailList(seq);
		mv.addObject("lodgeDetail", lodgeDetail);
		
		
		 /* 평점 추가 */
				String lodgeName = lodgeDetail.getLodgeName();
				String star = lodgeService.lodgeDetailStar(lodgeName);
				HttpSession session = request.getSession();
				session.setAttribute("star", star);
				System.out.println(lodgeName+","+ session.getAttribute(star)+","+star);
				mv.addObject("star", star);
		return mv;

	}
	
		
	/* 객실 목록 ajax */
	@ResponseBody
	@RequestMapping(value="/ajax/roomList/everyCount",method=RequestMethod.POST)
	public List<LodgeRoomDto> roomListEveryCountList(@RequestParam("chkInDate") Date chkInDate, @RequestParam("chkOutDate") Date chkOutDate ,@RequestParam("lodgeName") String lodgeName,@RequestParam("roomCount") int roomCount) throws Exception{
		List<LodgeRoomDto> bookList = new ArrayList<LodgeRoomDto>(); 
 		bookList =lodgeService.selectRoomEveryCountList(chkInDate, chkOutDate, lodgeName,roomCount);
 		return bookList;
	}
	
	
	/* 숙소 결제 내용 */
	@RequestMapping(value="/lodge/lodgePay{seq}", method=RequestMethod.GET) 
	public ModelAndView lodgePay(@PathVariable("seq") int seq, HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("lodge/lodgePay");
		String chkInDate= request.getParameter("chkInDate");
		String chkOutDate= request.getParameter("chkOutDate");
		HttpSession session = request.getSession();
		session.setAttribute("chkInDate", chkInDate);
		session.setAttribute("chkOutDate", chkOutDate);
		
		/* 객실 정보 출력 */
		List<LodgeRoomDto> payList = lodgeService.payList(seq);
		mv.addObject("payList", payList);
		return mv;
	}
	
	
	/* 숙소 결제 db입력 */
	@RequestMapping(value="/lodge/lodgePay", method=RequestMethod.POST) 
	public String roomInsert(LodgeDto room) throws Exception {
		lodgeService.roomInsert(room);
		
		/* 결제 시 해당 날짜 검색 불가 */
		lodgeService.dateUpdate(room);
		
		return "./main";
	}
	
	
	 /* 숙소 예약/결제 확인 목록 */
	 @RequestMapping(value="/lodge/lodgePayChk", method=RequestMethod.GET) 
	 public String lodgePayChk(Model model, HttpSession session) throws Exception{
		 String userEmail = (String) session.getAttribute("email");
		 List<LodgeDto> chkList = lodgeService.lodgePayChk(userEmail);
		 
		 model.addAttribute("chkList", chkList);
		 
		 return "lodge/lodgePayChk";
	 }
	 
	 
	 /* 숙소 예약/결제 확인 삭제 */
	@ResponseBody
	@RequestMapping(value = "/lodge/lodgeDelete")
	public Map<String, String> lodgeDelete(@RequestParam("seq") int seq) throws Exception {
		
		Map<String, String> result = new HashMap<String, String>();

		lodgeService.lodgeDelete(seq);

		result.put("result", "success");

		return result;
	}
}














