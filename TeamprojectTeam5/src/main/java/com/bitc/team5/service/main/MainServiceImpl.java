package com.bitc.team5.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.FestivalDto;
import com.bitc.team5.mapper.MainMapper;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainMapper mainMapper;
	
	@Override
	public List<FestivalDto> selectAllHotList() throws Exception {
		
		return mainMapper.selectAllHotList();
	}

}
