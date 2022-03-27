package com.bitc.team5.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitc.team5.dto.DibDto;
import com.bitc.team5.service.dib.DibService;

@Controller
public class DibController {
	
	@Autowired
	private DibService dibService;
	
	@ResponseBody
	@RequestMapping(value = "/dib/add", method = RequestMethod.POST)
	public Object addDib(DibDto dib, HttpSession session) throws Exception {
		
		String email = (String) session.getAttribute("email");
		dib.setEmail(email);
		
		dibService.addDib(dib);
		
//		Map<String, String> result = new HashMap<String, String>();
//		result.put("result", "success");
		
		return "success";
	}
	
	@RequestMapping(value = "/diblist", method = RequestMethod.GET)
	public String dibList(Model model, HttpSession session) throws Exception {
		
		String email = (String) session.getAttribute("email");
		
		List<DibDto> dibList = dibService.dibList(email);
		
		model.addAttribute("dibList", dibList);
		
		return "dib/diblist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/dib/dibDelete")
	public Map<String, String> dibDelete(@RequestParam("seq") int seq) throws Exception {
		
		Map<String, String> result = new HashMap<String, String>();

		dibService.deleteDib(seq);

		result.put("result", "success");

		return result;
	}
	

}
