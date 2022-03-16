package com.bitc.team5.service.dib;

import java.util.List;

import com.bitc.team5.dto.DibDto;

public interface DibService {

	// 찜 추가
	void addDib(DibDto dib) throws Exception;

	// 찜 목록
	List<DibDto> dibList(String email) throws Exception;

	// 찜 삭제
	void deleteDib(int seq) throws Exception;

}
