package com.bitc.team5.controller;

import java.sql.Date;
import java.util.ArrayList;
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
	
	/* 숙소 찾기 페이지(지도)*/
	@RequestMapping(value="/lodge/lodgeSearch", method=RequestMethod.GET) 
	public String lodgeSearch() throws Exception { 
		return "/lodge/lodgeSearch"; 
	}
	
	/* 숙소 확인 페이지 */
	@RequestMapping(value="/lodge/lodgeBook", method=RequestMethod.GET) 
	public String lodgeBook() throws Exception { 
		return "/lodge/lodgeBook"; 
	}

	
	/////////////////////////////////////////////////////
	///////
	
	
	/* 숙소 찾기 페이지(지도)2*/
	@RequestMapping(value="/lodge/lodgeSearch2", method=RequestMethod.GET) 
	public String lodgeSearch2() throws Exception { 
		return "/lodge/lodgeSearch2"; 
	}
	
//	@RequestMapping(value="/lodge/lodgeSearch2{lodgeName}", method=RequestMethod.GET) 
//	public String lodgeSearch2(@PathVariable("lodgeName") String lodgeName) throws Exception { 
//		return "/lodge/lodgeSearch2"; 
//	}
	

	/* 숙소 확인 페이지2 */
	
	/*
	 * @RequestMapping(value="/lodge/lodgeBook2", method=RequestMethod.GET) public
	 * String lodgeBook2() throws Exception { return "/lodge/lodgeBook2"; }
	 */
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/lodge/lodgeBook2", method=RequestMethod.GET) public
	 * String lodgeBook2(@RequestParam("lodgeName") String lodgeName) throws
	 * Exception { System.out.println(lodgeName); return "/lodge/lodgeBook2"; }
	 */
	
	@ResponseBody
	@RequestMapping(value="/lodge/lodgeBook2", method=RequestMethod.GET) 
	public String lodgeBook2(@RequestParam Map<String, Object> param) throws Exception { 
		String lodegName = (String) param.get("lodgeName");	
		System.out.println(param.get("lodgeName"));
		
		return "lodgeName"; 
	}

	
	//////////////////////////////////////////////
	
	/* 숙소 찾기 페이지(지도)3*/
	@RequestMapping(value="/lodge/lodgeSearch3", method=RequestMethod.GET) 
	public String lodgeSearch3() throws Exception { 
		return "/lodge/lodgeSearch3"; 
	}
	
	/* 숙소 확인 페이지3 */
//	@RequestMapping(value="/lodge/lodgeBook3", method=RequestMethod.GET) 
//	public String lodgeBook3() throws Exception { 
//		return "/lodge/lodgeBook3"; 
//	}
	
	/* 숙소 확인 페이지3 + 객실 조회*/
//	@RequestMapping(value="/lodge/lodgeBook3", method=RequestMethod.GET) 
//	public ModelAndView lodgeRoomList() throws Exception {
//		ModelAndView mv = new ModelAndView("/lodge/lodgeBook3");
//		
//		List<LodgeRoomDto> roomList = lodgeService.selectRoomList();
//		mv.addObject("roomList", roomList);
//		
//		return mv;
//
//	}
	
	@RequestMapping(value="/lodge/lodgeBook3", method=RequestMethod.GET)
	public ModelAndView lodgeRoomList(HttpServletRequest request, Model model) throws Exception {
		String aName= request.getParameter("aName");
		String pName= request.getParameter("pName");
		String phone= request.getParameter("phone");
		HttpSession session = request.getSession();
		session.setAttribute("aName", aName);
		session.setAttribute("pName", pName);
		session.setAttribute("phone", phone);
//		print print = new print();
		
//		System.out.println(aName+", "+pName+", "+phone);
//		System.out.println(session.getAttribute("email")+", "+session.getAttribute("aName")+", "+session.getAttribute("pName")+", "+session.getAttribute("phone"));
		
		
		ModelAndView mv = new ModelAndView("/lodge/lodgeBook3");
		List<LodgeRoomDto> roomList = lodgeService.selectRoomList(pName);
		
//		숙소 이름에 맞는 이미지 출력
//		System.out.println(pName);
		String imgUrl = null;
		for (LodgeRoomDto room : roomList) {
			if(room.getLodgeName().equals(pName)) {
				imgUrl = room.getLodgeImg();
			}
		}
		
//		System.out.println(imgUrl);
		mv.addObject("roomList", roomList);
		mv.addObject("imgUrl", imgUrl);
		
		return mv;
		
	}
	
	
//	객실 목록 ajax
 	@ResponseBody
	@RequestMapping(value="/ajax/roomList", method=RequestMethod.POST)
 	//roomCountOnly
 	public List<LodgeRoomDto> roomList(@RequestParam("roomCount") int roomCount,@RequestParam("lodgeName") String lodgeName) throws Exception {

//		List<LodgeRoomDto> bookList = lodgeService.roomList(roomCount);
 		List<LodgeRoomDto> bookList = new ArrayList<LodgeRoomDto>(); 
 		bookList =lodgeService.selectRoomCountList(roomCount, lodgeName);
		
		return bookList;
	}

	@ResponseBody
	@RequestMapping(value="/ajax/roomList/dateOnly",method=RequestMethod.POST)
	//roomDate Only
	public List<LodgeRoomDto> roomListDateOnly(@RequestParam("chkInDate") Date chkInDate, @RequestParam("chkOutDate") Date chkOutDate ,@RequestParam("lodgeName") String lodgeName) throws Exception {
//		List<LodgeRoomDto> bookList = lodgeService.roomList(roomCount);
 		List<LodgeRoomDto> bookList = new ArrayList<LodgeRoomDto>(); 
 		bookList =lodgeService.selectRoomDateOnlyList(chkInDate, chkOutDate, lodgeName);

		return bookList;
	}
	@ResponseBody
	@RequestMapping(value="/ajax/roomList/everyCount",method=RequestMethod.POST)
	public List<LodgeRoomDto> roomListEveryCountList(@RequestParam("chkInDate") Date chkInDate, @RequestParam("chkOutDate") Date chkOutDate ,@RequestParam("lodgeName") String lodgeName,@RequestParam("roomCount") int roomCount) throws Exception{
		List<LodgeRoomDto> bookList = new ArrayList<LodgeRoomDto>(); 
 		bookList =lodgeService.selectRoomEveryCountList(chkInDate, chkOutDate, lodgeName,roomCount);
 		return bookList;
	}
	
	

//	@RequestMapping(value="/lodge/lodgeBook3", method=RequestMethod.GET)
//	public String lodgeBook2(HttpServletRequest request, Model model) throws Exception {
//		String aName= request.getParameter("aName");
//		String pName= request.getParameter("pName");
//		String phone= request.getParameter("phone");
//		HttpSession session = request.getSession();
//		session.setAttribute("aName", aName);
//		session.setAttribute("pName", pName);
//		session.setAttribute("phone", phone);
//		print print = new print();
//		
//		System.out.println(aName+", "+pName+", "+phone);
//		System.out.println(session.getAttribute("email")+", "+session.getAttribute("aName")+", "+session.getAttribute("pName")+", "+session.getAttribute("phone"));
//		
//		return "/lodge/lodgeBook3";
//		
//	}
	
	
//	@RequestMapping(value="/lodge/lodgeBook3?pName={name}&aName={addrname}&phone={phone}", method=RequestMethod.GET) 
//	public ModelAndView lodgeRoomList() throws Exception {
//		ModelAndView mv = new ModelAndView("/lodge/lodgeBook3");
//		
//		List<LodgeRoomDto> roomList = lodgeService.selectRoomList();
//		mv.addObject("roomList", roomList);
//		
//		return mv;
//	}
	
//	@ResponseBody
//	@RequestMapping(value="http://localhost:8080/lodge/lodgeBook3?pName={name}&aName={addrname}&phone={phone}", method=RequestMethod.GET) 
//	public Object roomBook(@RequestParam("name") String name) throws Exception {
//		return "/lodge/lodgeBook3";
//	}
	
//	
//	@GetMapping("/lodge/lodgeBook3")
//	   public List<lodgeBookDto> getRoomById(@RequestParam Long name) throws Exception{
//	      return lodgeService.selectRoomById(name);
//	   }
	
	
	/////////////////////////////////////////////////////////////////////////
	
	/* 명소별 숙소 목록*/
	 @RequestMapping(value="/lodge/lodgeList", method=RequestMethod.GET) 
	 public ModelAndView lodgeList() throws Exception {
	 	ModelAndView mv = new ModelAndView("/lodge/lodgeList");
	  
		 List<LodgeListDto> lodgeList = lodgeService.selectLodgeList();
		 mv.addObject("lodgeList", lodgeList);
		 
		 return mv; 
	}
	 
	 
	/* 숙소 상세*/
	@RequestMapping(value="/lodge/lodgeListBook/{seq}", method=RequestMethod.GET) 
	public ModelAndView lodgeDetail(@PathVariable("seq") int seq, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/lodge/lodgeListBook");
		
		LodgeListDto lodgeDetail = lodgeService.lodgeDetailList(seq);
		mv.addObject("lodgeDetail", lodgeDetail);
		
		List<LodgeRoomDto> roomList = lodgeService.roomList();
		mv.addObject("roomList", roomList);
		
		// 평점 부분
				String lodgeName = lodgeDetail.getLodgeName();
				String star = lodgeService.lodgeDetailStar(lodgeName);
				HttpSession session = request.getSession();
				session.setAttribute("star", star);
				System.out.println(lodgeName+","+ session.getAttribute(star)+","+star);
				mv.addObject("star", star);
		return mv;

	}
	
	/* 객실 예약 */
//	@RequestMapping(value="/lodge/lodgeListBook", method=RequestMethod.POST) 
//	public String roomInsert(LodgeDto room) throws Exception {
//		lodgeService.roomInsert(room);
//		
//		return "redirect:/main";
//	}
	
	@RequestMapping(value="/lodge/lodgePay", method=RequestMethod.POST) 
	public String roomInsert(LodgeDto room) throws Exception {
		lodgeService.roomInsert(room);
		
		return "/main";
	}
	
	/* 결제 페이지 */
	@RequestMapping(value="/lodge/lodgePay{seq}", method=RequestMethod.GET) 
	public ModelAndView lodgePay(@PathVariable("seq") int seq, HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("/lodge/lodgePay");
		String chkInDate= request.getParameter("chkInDate");
		String chkOutDate= request.getParameter("chkOutDate");
		HttpSession session = request.getSession();
		session.setAttribute("chkInDate", chkInDate);
		session.setAttribute("chkOutDate", chkOutDate);
		
		List<LodgeRoomDto> payList = lodgeService.payList(seq);
		mv.addObject("payList", payList);
		return mv;

	}
}














