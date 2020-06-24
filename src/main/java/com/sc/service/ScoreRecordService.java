package com.sc.service;

import com.sc.entity.ScoreRecord;
import com.sc.mapper.ScoreRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScoreRecordService {
    @Autowired
    ScoreRecordMapper scoreRecordMapper;

    /**
     * 创建积分记录
     * @param userId
     * @param scoreRecordTime
     * @param scoreRecordType
     * @param scoreRecordNum
     */
    public void creatScoreRecordToday(String userId, String scoreRecordTime, String scoreRecordType, int scoreRecordNum){
        scoreRecordMapper.creatScoreRecordToday(userId, scoreRecordTime, scoreRecordType, scoreRecordNum);
    }

    /**
     * 得到某用户某天的积分记录
     * @param theUserId
     * @param scoreRecordTime
     * @return
     */
    public List<ScoreRecord> checkScoreForDay(String theUserId, String scoreRecordTime){
        return scoreRecordMapper.checkScoreForDay(theUserId, scoreRecordTime);
    }
}
