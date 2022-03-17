package com.bitc.team5.service.lodge;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.LodgeDto;
import com.bitc.team5.dto.LodgeListDto;
import com.bitc.team5.dto.LodgeRoomDto;
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
	public List<LodgeRoomDto> selectRoomList(String pName) throws Exception {
		return lodgeMapper.selectRoomList(pName);
	}

//	@Override
//	public List<LodgeRoomDto> roomList(String roomCount) throws Exception {
//		return lodgeMapper.roomList(roomCount);
//	}

	@Override
	public List<LodgeRoomDto> selectRoomCountList(int roomCount, String lodgeName) throws Exception {
		return lodgeMapper.selectRoomCountList(roomCount, lodgeName);
	}

	@Override
	public List<LodgeRoomDto> selectRoomDateOnlyList(Date chkInDate, Date chkOutDate, String lodgeName) throws Exception {
		// TODO Auto-generated method stub
		return lodgeMapper.selectRoomDateOnlyList(chkInDate,chkOutDate,lodgeName);
	}

	@Override
	public List<LodgeRoomDto> selectRoomEveryCountList(Date chkInDate, Date chkOutDate, String lodgeName, int roomCount)
			throws Exception {
		// TODO Auto-generated method stub
		return lodgeMapper.selectRoomEveryCountList(chkInDate,chkOutDate,lodgeName,roomCount);
	}


//	@Override
//	public List<lodgeBookDto> selectRoomById(Long name) throws Exception {
//		return lodgeMapper.selectRoomById(name);
//	}

	////////////////////////////////////////
	
	/* 명소별 숙소 목록*/
	@Override
	public List<LodgeListDto> selectLodgeList() throws Exception {
		return lodgeMapper.selectLodgeList();
	}

	@Override
	public LodgeListDto lodgeDetailList(int seq) throws Exception {
		return lodgeMapper.lodgeDetailList(seq);
	}

	@Override
	public List<LodgeRoomDto> roomList() throws Exception {
		return lodgeMapper.roomLIst();
	}

	/* 객실 예약 */
	@Override
	public void roomInsert(LodgeDto room) throws Exception {
		lodgeMapper.roomInsert(room);
	}

	/* 결제 페이지 */
	@Override
	public List<LodgeRoomDto> payList(int seq) throws Exception {
		return lodgeMapper.payList(seq);
	}

}
