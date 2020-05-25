package com.sc.service;

import com.sc.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 通过账号密码得到用户
     * @param userId
     * @param userPassword
     * @return
     */
    List<User> getUsersByIAndP(String userId, String userPassword);

    /**
     * 得到该id的所有用户
     * @param userId
     * @return
     */
    User getUserByUserId(String userId);

    /**
     * 得到该id的所有用户
     * @param userId
     * @return
     */
    List<User> getUsersByUserId(String userId);

    /**
     * 创建新用户
     * @param userId
     * @param userPassword
     */
    void creatUser(String userId, String userPassword);

    /**
     * 上次修改数据时间
     * @param userId
     * @return
     */
    String getTodayOfId(String userId);

    /**
     * 设置每日数据
     * @param userId
     * @param walkToday
     * @param busToday
     * @param shopToday
     * @return
     */
    void setTodayData(String userId, int walkToday, int busToday, int shopToday, String nowDate);

    /**
     * 通过id得到总积分
     * @param userId
     * @return
     */
    int getScoreById(String userId);

    /**
     * 通过id得到总余额
     * @param userId
     * @return
     */
    float getAccountById(String userId);

    /**
     * 通过id修改总积分
     * @param userId
     * @param userScore
     * @return
     */
    void setScoreById(String userId, int userScore);

    /**
     * 通过id修改总余额
     * @param userId
     * @param userAccount
     * @return
     */
    void setAccountById( String userId, float userAccount);

    /**
     * 全国前10
     * @return
     */
    List<User> getCountryTop10();

    /**
     * 城市前10
     * @param userCity
     * @return
     */
    List<User> getCityTop10(String userCity);

    /**
     * 给该用户设置 theFriendId 用于判断是否关注
     * @param userId
     * @param friendId
     */
    void setFriendIdById(String userId, String friendId);

    /**
     * 好友前10
     * @param userId
     * @return
     */
    List<User> getFriendTop10(String userId);
}
