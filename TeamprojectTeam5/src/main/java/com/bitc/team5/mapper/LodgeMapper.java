package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team5.dto.LodgeDto;
import com.bitc.team5.dto.LodgeRoomDto;


@Mapper
public interface LodgeMapper {

	/* 숙소 예약 내용 저장 */
	void insertLodge(LodgeDto lodge) throws Exception;

	/* 숙소 확인 페이지3 + 객실 조회*/
	List<LodgeRoomDto> selectRoomList() throws Exception;

//	List<LodgeRoomDto> roomList(String roomCount) throws Exception;

	List<LodgeRoomDto> selectRoomCountList(@Param("roomCount")String roomCount, @Param("lodgeName")String lodgeName);

//	List<lodgeBookDto> selectRoomById(Long name) throws Exception;

}
