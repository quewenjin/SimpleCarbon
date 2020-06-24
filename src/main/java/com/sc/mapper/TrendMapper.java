package com.sc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TrendMapper {
    /**
     * 某用户的所有动态图片url
     * @param theUserId
     * @return
     */
    List<String> getTrendPicture(@Param("theUserId")String theUserId);
}
