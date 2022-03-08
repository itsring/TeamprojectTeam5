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
	public String lodgeSearch(HttpServletRequest request) throws Exception { 
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("email");
		return "/lodge/lodgeSearch"; 
	}
	
	/* 숙소 확인 페이지 */
	@RequestMapping(value="/lodge/lodgeBook", method=RequestMethod.GET) 
	public String lodgeBook() throws Exception { 
		return "/lodge/lodgeBook"; 
	}
	
	/* 숙소 예약 내용 저장 */	
	@RequestMapping(value="/lodge/lodgeBook", method=RequestMethod.POST)
	public String insertLodge(LodgeDto lodge) throws Exception {
		lodgeService.insertLodge(lodge);
		
		return "redirect:/main";
	}
}
