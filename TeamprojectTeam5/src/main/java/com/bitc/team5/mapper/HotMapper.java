package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.HotDto;

@Mapper
public interface HotMapper {

	void hotinsert(HotDto hotPlace) throws Exception;

	List<HotDto> selectHotList() throws Exception;
	List<HotDto> selectMarketList() throws Exception;
	List<HotDto> selectLandList() throws Exception;
	List<HotDto> selectParkList() throws Exception;
	List<HotDto> selectWalkList() throws Exception;

	HotDto hotDetailList(int seq) throws Exception;

	void hotUpdateBoard(HotDto hotupdate) throws Exception;

	

	

	

	

	

	

	

}
