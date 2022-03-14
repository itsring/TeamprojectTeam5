package com.bitc.team5.service.lodge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.LodgeDto;
import com.bitc.team5.dto.LodgeRoomDto;
import com.bitc.team5.dto.lodgeBookDto;
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

	/* 숙소 확인 페이지3 + 객실 조회*/
	@Override
	public List<LodgeRoomDto> selectRoomList() throws Exception {
		return lodgeMapper.selectRoomList();
	}

//	@Override
//	public List<LodgeRoomDto> roomList(String roomCount) throws Exception {
//		return lodgeMapper.roomList(roomCount);
//	}

	@Override
	public List<LodgeRoomDto> selectRoomCountList(String roomCount, String lodgeName) throws Exception {
		return lodgeMapper.selectRoomCountList(roomCount, lodgeName);
	}


//	@Override
//	public List<lodgeBookDto> selectRoomById(Long name) throws Exception {
//		return lodgeMapper.selectRoomById(name);
//	}


}
