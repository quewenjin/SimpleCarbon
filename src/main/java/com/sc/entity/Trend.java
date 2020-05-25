package com.sc.entity;

public class Trend {
    private int trendId;
    private String theUserName;
    private String TrendPicture;

    public int getTrendId() {
        return trendId;
    }

    public void setTrendId(int trendId) {
        this.trendId = trendId;
    }

    public String getTheUserName() {
        return theUserName;
    }

    public void setTheUserName(String theUserName) {
        this.theUserName = theUserName;
    }

    public String getTrendPicture() {
        return TrendPicture;
    }

    public void setTrendPicture(String trendPicture) {
        TrendPicture = trendPicture;
    }

    @Override
    public String toString() {
        return "Trend{" +
                "trendId=" + trendId +
                ", theUserName='" + theUserName + '\'' +
                ", TrendPicture='" + TrendPicture + '\'' +
                '}';
    }
}
