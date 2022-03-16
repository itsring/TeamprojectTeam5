package com.bitc.team5.service.dib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.DibDto;
import com.bitc.team5.mapper.DibMapper;

@Service
public class DibServiceImpl implements DibService {
	
	@Autowired
	private DibMapper dibMapper;
	
	// 찜하기 추가
	@Override
	public void addDib(DibDto dib) throws Exception {
		dibMapper.addDib(dib);
	}
	
	// 찜 목록
	@Override
	public List<DibDto> dibList(String email) throws Exception {
		List<DibDto> dib = dibMapper.getDib(email);
		return dib;
	}
	
	// 찜 삭제
	@Override
	public void deleteDib(int seq) throws Exception {
		dibMapper.deleteDib(seq);
		
	}

	
}
