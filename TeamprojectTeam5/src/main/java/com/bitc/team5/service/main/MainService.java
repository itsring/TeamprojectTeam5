package com.bitc.team5.service.main;

import java.util.List;

import com.bitc.team5.dto.FestivalDto;
import com.bitc.team5.dto.LodgeListDto;

public interface MainService {

	List<FestivalDto> selectAllHotList() throws Exception;

	List<LodgeListDto> selectLodgeList() throws Exception;

}
