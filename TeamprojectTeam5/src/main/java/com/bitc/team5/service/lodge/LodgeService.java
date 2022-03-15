package com.bitc.team5.service.lodge;

import java.sql.Date;
import java.util.List;

import com.bitc.team5.dto.LodgeDto;
import com.bitc.team5.dto.LodgeRoomDto;

public interface LodgeService {
	/* 숙소 예약 내용 저장 */
	void insertLodge(LodgeDto lodge) throws Exception;

	/* 숙소 확인 페이지3 + 객실 조회*/
	List<LodgeRoomDto> selectRoomList(String pName) throws Exception;

//	List<LodgeRoomDto> roomList(String roomCount) throws Exception;

	List<LodgeRoomDto> selectRoomCountList(int roomCount, String lodgeName) throws Exception;

	List<LodgeRoomDto> selectRoomDateOnlyList(Date chkInDate, Date chkOutDate, String lodgeName) throws Exception;

	List<LodgeRoomDto> selectRoomEveryCountList(Date chkInDate, Date chkOutDate, String lodgeName, int roomCount) throws Exception;

//	List<lodgeBookDto> selectRoomById(Long name) throws Exception;


}
