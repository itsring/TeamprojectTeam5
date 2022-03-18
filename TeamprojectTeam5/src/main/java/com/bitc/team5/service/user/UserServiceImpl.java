package com.bitc.team5.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.DibDto;
import com.bitc.team5.dto.UserDto;
import com.bitc.team5.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void userJoin(UserDto user) throws Exception {
		userMapper.userJoin(user);
		
	}

	@Override
	public int loginCheck(String email, String password) throws Exception {
		// 로그인 체크
		return userMapper.loginCheck(email,password);
	}

	@Override
	public List<UserDto> selectUserList() throws Exception {
		// 메인페이지 유저 목록 불러오기 & thymeleaf로 조건문
		return userMapper.selectUserList();
	}

	@Override
	public UserDto selectUserDetail(String email) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserDetail(email);
	}

	@Override
	public void updateUser(UserDto user) throws Exception {
		userMapper.updateUser(user);
		
	}

	@Override
	public void userDelete(UserDto user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.userDelete(user);
	}

	@Override
	public UserDto selectUserDetail2(String email) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserDetail2(email);
	}

	@Override
	public List<DibDto> dibList(String email) throws Exception {
		
		return userMapper.dibList(email);
	}

	

}
