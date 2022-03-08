package com.bitc.team5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.UserDto;
import com.bitc.team5.service.user.UserService;

@Controller
public class MainController {
	
	//모두 String 반환으로 만들어 놨으니(임시) 반환값 필요시 변경하세요
	//페이지 연결 우선으로 해놨습니다. 
	@Autowired
	private UserService userService;
	
	
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
		return mv;
	}
	//로그인페이지
	@RequestMapping("/login")
	public String login() throws Exception{
		//이메일, 비밀번호
		return "/user/login";
	}
	//로그인체크
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(UserDto user, HttpServletRequest request) throws Exception {
		int count = userService.loginCheck(user.getEmail(), user.getPassword());
		UserDto userDetail = userService.selectUserDetail2(user.getEmail());
		if (count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("email", user.getEmail());
			session.setAttribute("userName", userDetail.getUserName());
//			session.setMaxInactiveInterval(30);
			return "redirect:/main";
		} else {
			//
			return "redirect:/loginFail";
		}
	}
	//회원가입 페이지
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String userJoinPage() throws Exception {
		return "/user/join";
	}
	//회원 등록
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String userJoin(UserDto user) throws Exception {
		userService.userJoin(user);
		return "redirect:/login";
	}
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		return "/user/login";
	}
	//로그인 실패
	@RequestMapping("/loginFail")
	public String loginFail() throws Exception{
		return "/user/loginFail";
	}
//	정보 수정 페이지
	@RequestMapping(value="/userEdit/{seq}", method=RequestMethod.GET)
	public ModelAndView userDetail(@PathVariable("seq") int seq) throws Exception{
		ModelAndView mv = new ModelAndView("/user/userEdit");
		UserDto user = userService.selectUserDetail(seq);
		mv.addObject("user", user);
		return mv;
	}
//	수정 완료 후 로그인 페이지로 이동
	@RequestMapping(value = "/userEdit/{seq}", method = RequestMethod.POST)
	public String updateUserList(UserDto user,HttpServletRequest request) throws Exception {
		userService.updateUser(user);
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/login";
	}
//	회원정보 삭제 후 메인페이지로 이동
	@RequestMapping(value = "/userEdit/{seq}", method = RequestMethod.DELETE)
	public String UserDelete(UserDto user,HttpServletRequest request) throws Exception {
		userService.userDelete(user);
//		회원정보 삭제후에도 로그인이 유지되는 상황 방지...
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/main";
	}
	
	
}
