package com.sc.service;

import com.sc.entity.User;
import com.sc.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    /**
     * 通过账号密码得到用户
     * @param userId
     * @param userPassword
     * @return
     */
    public List<User> getUsersByIAndP(String userId, String userPassword){
        return userMapper.getUsersByIAndP(userId, userPassword);
    }

    /**
     * 得到该id的所有用户
     * @param userId
     * @return
     */
    public User getUserByUserId(String userId){
        return userMapper.getUserByUserId(userId);
    }

    /**
     * 得到该id的所有用户
     * @param userId
     * @return
     */
    public List<User> getUsersByUserId(String userId){
        return userMapper.getUsersByUserId(userId);
    }

    /**
     * 创建新用户
     * @param userId
     * @param userPassword
     */
    public void creatUser(String userId, String userPassword){
        userMapper.creatUser(userId, userPassword);
    }

    /**
     * 上次修改数据时间
     * @param userId
     * @return
     */
    public String getTodayOfId(String userId){
        return userMapper.getTodayOfId(userId);
    }

    /**
     * 设置每日数据
     * @param userId
     * @param walkToday
     * @param busToday
     * @param shopToday
     * @return
     */
    public void setTodayData(String userId, int walkToday, int busToday, int shopToday, String nowDate){
        userMapper.setTodayData(userId, walkToday, busToday, shopToday, nowDate);
    }

    /**
     * 通过id得到总积分
     * @param userId
     * @return
     */
    public int getScoreById(String userId){
        return userMapper.getScoreById(userId);
    }

    /**
     * 通过id得到总余额
     * @param userId
     * @return
     */
    public float getAccountById(String userId){
        return userMapper.getAccountById(userId);
    }

    /**
     * 通过id修改总积分
     * @param userId
     * @param userScore
     * @return
     */
    public void setScoreById(String userId, int userScore){
        userMapper.setScoreById(userId, userScore);
    }

    /**
     * 通过id修改总余额
     * @param userId
     * @param userAccount
     * @return
     */
    public void setAccountById( String userId, float userAccount){
        userMapper.setAccountById(userId, userAccount);
    }

    /**
     * 全国前10
     * @return
     */
    public List<User> getCountryTop10(){
        return userMapper.getCountryTop10();
    }

    /**
     * 城市前10
     * @param userCity
     * @return
     */
    public List<User> getCityTop10(String userCity){
        return userMapper.getCityTop10(userCity);
    }

    /**
     * 给该用户设置 theFriendId 用于判断是否关注
     * @param userId
     * @param friendId
     */
    public void setFriendIdById(String userId, String friendId){
        userMapper.setFriendIdById(userId, friendId);
    }

    /**
     * 好友前10
     * @param userId
     * @return
     */
    public List<User> getFriendTop10(String userId){
        return userMapper.getFriendTop10(userId);
    }
}
