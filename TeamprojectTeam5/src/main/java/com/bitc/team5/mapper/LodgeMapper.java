package com.bitc.team5.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team5.dto.LodgeDto;

@Mapper
public interface LodgeMapper {

	/* 숙소 예약 내용 저장 */
	void insertLodge(LodgeDto lodge) throws Exception;
	

}
