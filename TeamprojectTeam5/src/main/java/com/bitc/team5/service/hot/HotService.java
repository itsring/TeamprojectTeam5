package com.bitc.team5.service.hot;

import java.util.List;

import com.bitc.team5.dto.HotDto;

public interface HotService {

	List<HotDto> selectHotList() throws Exception;
	List<HotDto> selectMarketList() throws Exception;
	List<HotDto> selectLandList() throws Exception;
	List<HotDto> selectParkList() throws Exception;
	List<HotDto> selectWalkList() throws Exception;

	HotDto hotDetailList(int seq) throws Exception;

	void hotUpdateBoard(HotDto hotupdate) throws Exception;
	
	void hotinsert(HotDto hotPlace) throws Exception;

	

	

	

	


}
