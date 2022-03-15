package com.bitc.team5.service.main;

import java.util.List;

import com.bitc.team5.dto.FestivalDto;

public interface MainService {

	List<FestivalDto> selectAllHotList() throws Exception;

}
