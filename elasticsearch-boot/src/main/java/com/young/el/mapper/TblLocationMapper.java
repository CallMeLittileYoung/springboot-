package com.young.el.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.young.el.document.LocationDocument;

@Mapper
public interface TblLocationMapper {
	
	List<LocationDocument> selectPositionsByCityNameAndCountyName(@Param("cityName")String cityName,@Param("countyName")String countyName);
}
