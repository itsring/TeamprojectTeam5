package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.FestivalDto;
import com.bitc.team5.dto.LodgeListDto;

@Mapper
public interface MainMapper {

	List<FestivalDto> selectAllHotList() throws Exception;

	List<LodgeListDto> selectLodgeList() throws Exception;

}
