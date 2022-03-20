package com.bitc.team5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.HotDto;
import com.bitc.team5.dto.LodgeListDto;
import com.bitc.team5.dto.UserDto;
import com.bitc.team5.service.hot.HotService;
import com.bitc.team5.service.main.MainService;
import com.bitc.team5.service.user.UserService;

@Controller
public class MainController {
	
	//모두 String 반환으로 만들어 놨으니(임시) 반환값 필요시 변경하세요
	//페이지 연결 우선으로 해놨습니다. 
	@Autowired
	private UserService userService;
	@Autowired
	private MainService mainService;
	@Autowired
	private HotService hotService;
	@RequestMapping("/")
	public String main() throws Exception{
		return "index";
	}
	//메인페이지
	@RequestMapping("/main")
	public ModelAndView viewMain(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("email");
		ModelAndView mv = new ModelAndView("main");
		if(userId!=null) {
			List<UserDto> user = userService.selectUserList();
			mv.addObject("user", user);
		}
		List<HotDto> hot = hotService.selectHotList();
		List<LodgeListDto> hotList = mainService.selectLodgeList();
		mv.addObject("hotList", hotList);
		mv.addObject("hot", hot);
		return mv;
	}
	
	
}
