package com.sc.dao;

import com.sc.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /**
     * 通过账号密码得到用户
     * @param userId
     * @param userPassword
     * @return
     */
    List<User> getUsersByIAndP(@Param("userId") String userId, @Param("userPassword") String userPassword);

    /**
     * 得到该id的用户
     * @param userId
     * @return
     */
    User getUserByUserId(@Param("userId")String userId);

    /**
     * 得到该id的所有用户
     * @param userId
     * @return
     */
    List<User> getUsersByUserId(@Param("userId")String userId);

    /**
     * 创建新用户
     * @param userId
     * @param userPassword
     */
    void creatUser(@Param("userId")String userId, @Param("userPassword") String userPassword);

    /**
     * 上次修改数据时间
     * @param userId
     * @return
     */
    String getTodayOfId(@Param("userId")String userId);

    /**
     * 设置每日数据
     * @param userId
     * @param walkToday
     * @param busToday
     * @param shopToday
     * @return
     */
    void setTodayData(@Param("userId")String userId, @Param("walkToday")int walkToday, @Param("busToday")int busToday,
                        @Param("shopToday")int shopToday, @Param("nowDate")String nowDate);

    /**
     * 通过id得到总积分
     * @param userId
     * @return
     */
    int getScoreById(@Param("userId")String userId);

    /**
     * 通过id得到总余额
     * @param userId
     * @return
     */
    float getAccountById(@Param("userId")String userId);

    /**
     * 通过id修改总积分
     * @param userId
     * @param userScore
     * @return
     */
    void setScoreById(@Param("userId")String userId, @Param("userScore")int userScore);

    /**
     * 通过id修改总余额
     * @param userId
     * @param userAccount
     * @return
     */
    void setAccountById(@Param("userId")String userId, @Param("userAccount")float userAccount);

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
    List<User> getCityTop10(@Param("userCity")String userCity);

    /**
     * 给该用户设置 theFriendId 用于判断是否关注
     * @param userId
     * @param friendId
     */
    void setFriendIdById(@Param("userId")String userId, @Param("friendId")String friendId);

    /**
     * 好友前10
     * @param userId
     * @return
     */
    List<User> getFriendTop10(@Param("userId")String userId);

}
