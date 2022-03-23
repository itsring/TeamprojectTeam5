package com.bitc.team5.service.lodge;

import java.sql.Date;
import java.util.List;

import com.bitc.team5.dto.LodgeDto;
import com.bitc.team5.dto.LodgeListDto;
import com.bitc.team5.dto.LodgeRoomDto;

public interface LodgeService {

	/* 명소별 제휴 숙소 목록*/
	List<LodgeListDto> selectLodgeList() throws Exception;
	
	/* 숙소 예약 상세*/
	LodgeListDto lodgeDetailList(int seq) throws Exception;
	
	/* 평점 추가 */
	String lodgeDetailStar(String lodgeName) throws Exception;
	
	/* 객실 목록 ajax */
	List<LodgeRoomDto> selectRoomEveryCountList(Date chkInDate, Date chkOutDate, String lodgeName, int roomCount) throws Exception;

	/* 숙소 결제 내용 */
	List<LodgeRoomDto> payList(int seq) throws Exception;
	
	/* 객실 정보 출력 */
	List<LodgeRoomDto> roomList() throws Exception;

	/* 숙소 결제 db입력 */
	void roomInsert(LodgeDto room) throws Exception;

	/* 결제 시 해당 날짜 검색 불가 */
	void dateUpdate(LodgeDto room) throws Exception;

	/* 숙소 예약/결제 확인 목록 */
	List<LodgeDto> lodgePayChk(String userEmail) throws Exception;

	/* 숙소 예약/결제 확인 삭제 */
	void lodgeDelete(int seq) throws Exception;

}
