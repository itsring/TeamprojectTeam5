package com.bitc.team5.service.hot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.HotDto;
import com.bitc.team5.mapper.HotMapper;

@Service
public class HotServiceImpl implements HotService {
	
	@Autowired
	private HotMapper hotMapper;

	@Override
	public void hotinsert(HotDto hotPlace) throws Exception {
		hotMapper.hotinsert(hotPlace);
		
	}

	@Override
	public List<HotDto> selectHotList() throws Exception {
		return hotMapper.selectHotList();
	}
	@Override
	public List<HotDto> selectMarketList() throws Exception {
		return hotMapper.selectMarketList();
	}
	@Override
	public List<HotDto> selectLandList() throws Exception {
		return hotMapper.selectLandList();
	}
	@Override
	public List<HotDto> selectParkList() throws Exception {
		return hotMapper.selectParkList();
	}
	@Override
	public List<HotDto> selectWalkList() throws Exception {
		return hotMapper.selectWalkList();
	}

	@Override
	public HotDto hotDetailList(int seq) throws Exception {
		return hotMapper.hotDetailList(seq);
	}

	@Override
	public void hotUpdateBoard(HotDto hotupdate) throws Exception {
		hotMapper.hotUpdateBoard(hotupdate);
		
	}

	

	

	

	
	
	

	

}
