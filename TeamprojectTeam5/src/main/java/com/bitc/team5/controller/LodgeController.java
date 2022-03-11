package com.bitc.team5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitc.team5.dto.LodgeDto;
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
//	
//	/* 숙소 예약 내용 저장 */	
//	@RequestMapping(value="/lodge/lodgeBook", method=RequestMethod.POST)
//	public String insertLodge(LodgeDto lodge) throws Exception {
//		lodgeService.insertLodge(lodge);
//		
//		return "redirect:/main";
//	}
	
	
	////////////////////////////////////////////////////////////
	
	
	/* 숙소 찾기 페이지(지도)2*/
	@RequestMapping(value="/lodge/lodgeSearch2", method=RequestMethod.GET) 
	public String lodgeSearch2() throws Exception { 
		return "/lodge/lodgeSearch2"; 
	}
	

	/* 숙소 확인 페이지2 */
	@RequestMapping(value="/lodge/lodgeBook2", method=RequestMethod.GET) 
	public String lodgeBook2() throws Exception { 
		return "/lodge/lodgeBook2"; 
	}
	
	
	
	 // 
//	@RequestMapping(value = "/lodge/lodgeBook2", method = RequestMethod.POST)
//	public String chkLodge(UserDto user,HttpServletRequest request) throws Exception {
//		userService.updateUser(user);
//		HttpSession session = request.getSession();
//		session.removeAttribute("userId");
//		session.invalidate();
//		return;
//	}
	
	
	
//	/* 숙소 예약 내용 저장 */	
//	@RequestMapping(value="/lodge/lodgeBook2", method=RequestMethod.POST)
//	public String insertLodge(LodgeDto lodge) throws Exception {
//		lodgeService.insertLodge(lodge);
//		
//		return "redirect:/main";
//	}
}
