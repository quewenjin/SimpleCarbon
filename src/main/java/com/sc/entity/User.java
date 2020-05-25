package com.sc.entity;

public class User {
    private String userId;
    private String userPassword;
    private String userName;//昵称(不是真实姓名)
    private String userCity;
    private int userScore;
    private float userAccount;
    private String userCheck;//是否实名
    private String userSlogn;//个性签名
    private String userPhoto;//头像
    private int walkToday;
    private int busToday;
    private int shopToday;
    private String today;
    private String theFriendId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public float getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(float userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserCheck() {
        return userCheck;
    }

    public void setUserCheck(String userCheck) {
        this.userCheck = userCheck;
    }

    public String getUserSlogn() {
        return userSlogn;
    }

    public void setUserSlogn(String userSlogn) {
        this.userSlogn = userSlogn;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public int getWalkToday() {
        return walkToday;
    }

    public void setWalkToday(int walkToday) {
        this.walkToday = walkToday;
    }

    public int getBusToday() {
        return busToday;
    }

    public void setBusToday(int busToday) {
        this.busToday = busToday;
    }

    public int getShopToday() {
        return shopToday;
    }

    public void setShopToday(int shopToday) {
        this.shopToday = shopToday;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getTheFriendId() {
        return theFriendId;
    }

    public void setTheFriendId(String theFriendId) {
        this.theFriendId = theFriendId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userScore=" + userScore +
                ", userAccount=" + userAccount +
                ", userCheck='" + userCheck + '\'' +
                ", userShake='" + userSlogn + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", walkToday=" + walkToday +
                ", busToday=" + busToday +
                ", shopToday=" + shopToday +
                ", today='" + today + '\'' +
                ", theFriendId='" + theFriendId + '\'' +
                '}';
    }
}
