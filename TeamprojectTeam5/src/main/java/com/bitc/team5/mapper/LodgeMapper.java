package com.bitc.team5.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team5.dto.LodgeDto;
import com.bitc.team5.dto.LodgeListDto;
import com.bitc.team5.dto.LodgeRoomDto;


@Mapper
public interface LodgeMapper {

	/* 숙소 예약 내용 저장 */
	void insertLodge(LodgeDto lodge) throws Exception;

	/* 숙소 확인 페이지3 + 객실 조회*/
	List<LodgeRoomDto> selectRoomList(@Param("pName") String pName) throws Exception;

//	List<LodgeRoomDto> roomList(String roomCount) throws Exception;

	List<LodgeRoomDto> selectRoomCountList(@Param("roomCount") int roomCount, @Param("lodgeName")String lodgeName) throws Exception;

	List<LodgeRoomDto> selectRoomDateOnlyList(@Param("chkInDate") Date chkInDate,@Param("chkOutDate") Date chkOutDate,@Param("lodgeName") String lodgeName) throws Exception;

	List<LodgeRoomDto> selectRoomEveryCountList(@Param("chkInDate") Date chkInDate,@Param("chkOutDate") Date chkOutDate,@Param("lodgeName") String lodgeName,@Param("roomCount") int roomCount) throws Exception;

//	List<lodgeBookDto> selectRoomById(Long name) throws Exception;

	///////////////////////////////
	
	/* 명소별 숙소 목록*/
	List<LodgeListDto> selectLodgeList() throws Exception;

	LodgeListDto lodgeDetailList(int seq) throws Exception;

	List<LodgeRoomDto> roomLIst() throws Exception;

	/* 객실 예약 */
	void roomInsert(LodgeDto room) throws Exception;

	/* 결제 페이지 */
	List<LodgeRoomDto> payList(int seq) throws Exception;

	String lodgeDetailStar(String lodgeName) throws Exception;

	/* 결제 시 객실 날짜 업데이트 */
	void dateUpdate(LodgeDto room) throws Exception;

//	숙소 예약 목록
	List<LodgeDto> getChk(String userEmail) throws Exception;

	// 숙소 예약 목록 삭제
	void lodgeDelete(int seq) throws Exception;


}
