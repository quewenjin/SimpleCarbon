package com.sc.entity;

public class ScoreRecord {
    private int scoreRecordId;
    private String scoreRecordTime;
    private String scoreRecordType;//1-步行， 2-公交， 3-绿色购物  4-积分消费
    private int scoreRecordNum;
    private String theUserId;

    public int getScoreRecordId() {
        return scoreRecordId;
    }

    public void setScoreRecordId(int scoreRecordId) {
        this.scoreRecordId = scoreRecordId;
    }

    public String getScoreRecordTime() {
        return scoreRecordTime;
    }

    public void setScoreRecordTime(String scoreRecordTime) {
        this.scoreRecordTime = scoreRecordTime;
    }

    public String getScoreRecordType() {
        return scoreRecordType;
    }

    public void setScoreRecordType(String scoreRecordType) {
        this.scoreRecordType = scoreRecordType;
    }

    public int getScoreRecordNum() {
        return scoreRecordNum;
    }

    public void setScoreRecordNum(int scoreRecordNum) {
        this.scoreRecordNum = scoreRecordNum;
    }

    public String getTheUserId() {
        return theUserId;
    }

    public void setTheUserId(String theUserId) {
        this.theUserId = theUserId;
    }

    @Override
    public String toString() {
        return "ScoreRecord{" +
                "scoreRecordId=" + scoreRecordId +
                ", scoreRecordTime='" + scoreRecordTime + '\'' +
                ", scoreRecordType='" + scoreRecordType + '\'' +
                ", scoreRecordNum=" + scoreRecordNum +
                ", theUserId='" + theUserId + '\'' +
                '}';
    }
}
