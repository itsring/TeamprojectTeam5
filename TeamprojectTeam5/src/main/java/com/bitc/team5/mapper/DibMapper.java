package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.DibDto;

@Mapper
public interface DibMapper {

	// 찜 추가
	public void addDib(DibDto dib) throws Exception;

	// 찜 목록
	public List<DibDto> getDib(String email) throws Exception;
	
	// 찜 삭제
	public void deleteDib(int seq) throws Exception;

	
}
