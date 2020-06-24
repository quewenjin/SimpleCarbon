package com.sc.service;

import com.sc.mapper.TrendMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrendService {
    @Autowired
    TrendMapper trendMapper;

    /**
     * 某用户的所有动态图片url
     * @param theUserId
     * @return
     */
    public List<String> getTrendPicture(@Param("theUserId")String theUserId){
        return trendMapper.getTrendPicture(theUserId);
    }
}
