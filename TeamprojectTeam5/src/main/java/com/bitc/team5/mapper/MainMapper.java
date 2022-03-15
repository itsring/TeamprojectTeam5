package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.FestivalDto;

@Mapper
public interface MainMapper {

	List<FestivalDto> selectAllHotList() throws Exception;

}
