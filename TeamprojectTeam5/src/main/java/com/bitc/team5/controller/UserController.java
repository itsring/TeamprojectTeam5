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

import com.bitc.team5.dto.DibDto;
import com.bitc.team5.dto.UserDto;
import com.bitc.team5.service.user.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
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
//				session.setMaxInactiveInterval(30);
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
		@RequestMapping(value="/user/myPage/{email}",method=RequestMethod.GET)
		public ModelAndView myPage(@PathVariable("email") String email, HttpSession session) throws Exception{
			ModelAndView mv = new ModelAndView("/user/myPage");
			UserDto userDetail = userService.selectUserDetail(email);
			
			List<DibDto> dibList = userService.dibList(email);
			mv.addObject("dibList",dibList);
			mv.addObject("user",userDetail);
			return mv;
		}
//		정보 수정 페이지
		@RequestMapping(value="/userEdit/{email}", method=RequestMethod.GET)
		public ModelAndView userDetail(@PathVariable("email") String email) throws Exception{
			ModelAndView mv = new ModelAndView("/user/userEdit");
			UserDto user = userService.selectUserDetail(email);
			mv.addObject("user", user);
			return mv;
		}
//		수정 완료 후 로그인 페이지로 이동
		@RequestMapping(value = "/userEdit/{email}", method = RequestMethod.PUT)
		public String updateUserList(UserDto user,HttpServletRequest request) throws Exception {
			userService.updateUser(user);
			HttpSession session = request.getSession();
			session.removeAttribute("userId");
			session.invalidate();
			return "redirect:/login";
		}
//		회원정보 삭제 후 메인페이지로 이동
		@RequestMapping(value = "/userEdit/{email}", method = RequestMethod.DELETE)
		public String UserDelete(UserDto user,HttpServletRequest request) throws Exception {
			userService.userDelete(user);
//			회원정보 삭제후에도 로그인이 유지되는 상황 방지...
			HttpSession session = request.getSession();
			session.removeAttribute("userId");
			session.invalidate();
			return "redirect:/main";
		}
		
//		@RequestMapping(value="/user/Mypage/{email}",method=RequestMethod.GET)
//		public String myPage(@PathVariable("email") String email) throws Exception{
//			ModelAndView mv = new ModelAndView("/user/myPage");
//			
//			return "/user/myPage";
//		}
		
}
