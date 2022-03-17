package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.HotDto;

@Mapper
public interface HotMapper {

	// 명소 메인 페이지 조회 부분
	List<HotDto> selectHotList() throws Exception;
	List<HotDto> selectMarketList() throws Exception;
	List<HotDto> selectLandList() throws Exception;
	List<HotDto> selectParkList() throws Exception;
	List<HotDto> selectWalkList() throws Exception;
	
	// 명소 등록 페이지
	void hotinsert(HotDto hotPlace) throws Exception;

	// 명소 상세 페이지
	HotDto hotDetailList(int seq) throws Exception;

	// 명소 수정 페이지
	void hotUpdateBoard(HotDto hotupdate) throws Exception;

	// 평점 첨가
	String hotDetailStar(String placeName) throws Exception;

	

	

	

	

	

	

	

}
