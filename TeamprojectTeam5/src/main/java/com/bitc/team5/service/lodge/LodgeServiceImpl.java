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

	/* 명소별 제휴 숙소 목록*/
	@Override
	public List<LodgeListDto> selectLodgeList() throws Exception {
		return lodgeMapper.selectLodgeList();
	}
	
	
	/* 숙소 예약 상세*/
	@Override
	public LodgeListDto lodgeDetailList(int seq) throws Exception {
		return lodgeMapper.lodgeDetailList(seq);
	}
	
	
	/* 평점 추가 */
	@Override
	public String lodgeDetailStar(String lodgeName) throws Exception {
		System.out.println(lodgeMapper.lodgeDetailStar(lodgeName));
		return lodgeMapper.lodgeDetailStar(lodgeName);
	}
	
	
	/* 객실 목록 ajax */
	@Override
	public List<LodgeRoomDto> selectRoomEveryCountList(Date chkInDate, Date chkOutDate, String lodgeName, int roomCount)
			throws Exception {
		// TODO Auto-generated method stub
		return lodgeMapper.selectRoomEveryCountList(chkInDate,chkOutDate,lodgeName,roomCount);
	}


	/* 숙소 결제 내용 */
	@Override
	public List<LodgeRoomDto> payList(int seq) throws Exception {
		return lodgeMapper.payList(seq);
	}
	
	
	/* 객실 정보 출력 */
	@Override
	public List<LodgeRoomDto> roomList() throws Exception {
		return lodgeMapper.roomLIst();
	}

	
	/* 숙소 결제 db입력 */
	@Override
	public void roomInsert(LodgeDto room) throws Exception {
		lodgeMapper.roomInsert(room);
	}

	
	/* 결제 시 해당 날짜 검색 불가 */
	@Override
	public void dateUpdate(LodgeDto room) throws Exception {
		lodgeMapper.dateUpdate(room);
	}
	

	/* 숙소 예약/결제 확인 목록 */
	@Override
	public List<LodgeDto> lodgePayChk(String userEmail) throws Exception {
		List<LodgeDto> chk = lodgeMapper.getChk(userEmail);
		return chk;
	}


	/* 숙소 예약/결제 확인 삭제 */
	@Override
	public void lodgeDelete(int seq) throws Exception {
		lodgeMapper.lodgeDelete(seq);
	}

}
