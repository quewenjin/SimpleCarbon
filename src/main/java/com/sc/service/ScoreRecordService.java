package com.sc.service;

import com.sc.entity.ScoreRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreRecordService {
    /**
     * 创建积分记录
     * @param userId
     * @param scoreRecordTime
     * @param scoreRecordType
     * @param scoreRecordNum
     */
    void creatScoreRecordToday(String userId, String scoreRecordTime, String scoreRecordType, int scoreRecordNum);

    /**
     * 得到某用户某天的积分记录
     * @param theUserId
     * @param scoreRecordTime
     * @return
     */
    List<ScoreRecord> checkScoreForDay(String theUserId, String scoreRecordTime);
}
