package com.bitc.team5.service.lodge;

import com.bitc.team5.dto.LodgeDto;

public interface LodgeService {
	/* 숙소 예약 내용 저장 */
	void insertLodge(LodgeDto lodge) throws Exception;


}
