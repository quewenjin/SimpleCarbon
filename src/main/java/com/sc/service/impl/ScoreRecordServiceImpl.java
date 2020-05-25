package com.sc.service.impl;

import com.sc.dao.ScoreRecordDao;
import com.sc.entity.ScoreRecord;
import com.sc.service.ScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreRecordServiceImpl implements ScoreRecordService {
    @Autowired
    private ScoreRecordDao scoreRecordDao;

    @Override
    public void creatScoreRecordToday(String userId, String scoreRecordTime, String scoreRecordType, int scoreRecordNum) {
        scoreRecordDao.creatScoreRecordToday(userId, scoreRecordTime, scoreRecordType, scoreRecordNum);
    }

    @Override
    public List<ScoreRecord> checkScoreForDay(String theUserId, String scoreRecordTime) {
        return scoreRecordDao.checkScoreForDay(theUserId, scoreRecordTime);
    }
}
