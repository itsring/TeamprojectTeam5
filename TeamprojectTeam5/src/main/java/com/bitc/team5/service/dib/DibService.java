package com.bitc.team5.service.dib;

import java.util.List;

import com.bitc.team5.dto.DibDto;

public interface DibService {

	void addDib(DibDto dib) throws Exception;

	List<DibDto> dibList(String email) throws Exception;

}
