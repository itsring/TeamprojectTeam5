package com.bitc.team5.service.lodge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.LodgeDto;
import com.bitc.team5.mapper.LodgeMapper;

@Service
public class LodgeServiceImpl implements LodgeService {
	
	@Autowired
	private LodgeMapper lodgeMapper;

	/* 숙소 예약 내용 저장 */
	@Override
	public void insertLodge(LodgeDto lodge) throws Exception {
		lodgeMapper.insertLodge(lodge);
		
	}
}
