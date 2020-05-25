package com.sc.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrendService {
    /**
     * 某用户的所有动态图片url
     * @param theUserId
     * @return
     */
    List<String> getTrendPicture(@Param("theUserId")String theUserId);
}
