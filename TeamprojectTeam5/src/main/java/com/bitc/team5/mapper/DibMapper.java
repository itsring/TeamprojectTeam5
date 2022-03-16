package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.DibDto;

@Mapper
public interface DibMapper {

	public void addDib(DibDto dib) throws Exception;

	public List<DibDto> getDib(String email) throws Exception;
	
}
