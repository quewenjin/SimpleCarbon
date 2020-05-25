package com.sc.dao;

import com.sc.entity.ScoreRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreRecordDao {

    /**
     * 创建积分记录
     * @param userId
     * @param scoreRecordTime
     * @param scoreRecordType
     * @param scoreRecordNum
     */
    void creatScoreRecordToday(@Param("userId")String userId, @Param("scoreRecordTime")String scoreRecordTime,
                             @Param("scoreRecordType")String scoreRecordType, @Param("scoreRecordNum")int scoreRecordNum);

    /**
     * 得到某用户某天的积分记录
     * @param theUserId
     * @param scoreRecordTime
     * @return
     */
    List<ScoreRecord> checkScoreForDay(@Param("theUserId")String theUserId, @Param("scoreRecordTime")String scoreRecordTime);
}
