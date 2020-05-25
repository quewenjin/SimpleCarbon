package com.sc.service.impl;

import com.sc.dao.UserDao;
import com.sc.entity.User;
import com.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsersByIAndP(String userId, String userPassword) {
        return userDao.getUsersByIAndP(userId, userPassword);
    }

    @Override
    public User getUserByUserId(String userId) {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public List<User> getUsersByUserId(String userId) {
        return userDao.getUsersByUserId(userId);
    }

    @Override
    public void creatUser(String userId, String userPassword) {
        userDao.creatUser(userId, userPassword);
    }

    @Override
    public String getTodayOfId(String userId) {
        return userDao.getTodayOfId(userId);
    }

    @Override
    public void setTodayData(String userId, int walkToday, int busToday, int shopToday, String nowDate) {
        userDao.setTodayData(userId, walkToday, busToday, shopToday, nowDate);
    }

    @Override
    public int getScoreById(String userId) {
        return userDao.getScoreById(userId);
    }

    @Override
    public float getAccountById(String userId) {
        return getAccountById(userId);
    }

    @Override
    public void setScoreById(String userId, int userScore) {
        userDao.setScoreById(userId, userScore);
    }

    @Override
    public void setAccountById(String userId, float userAccount) {
        userDao.setAccountById(userId, userAccount);
    }

    @Override
    public List<User> getCountryTop10() {
        return userDao.getCountryTop10();
    }

    @Override
    public List<User> getCityTop10(String userCity) {
        return userDao.getCityTop10(userCity);
    }

    @Override
    public void setFriendIdById(String userId, String friendId) {
        userDao.setFriendIdById(userId, friendId);
    }

    @Override
    public List<User> getFriendTop10(String userId) {
        return userDao.getFriendTop10(userId);
    }


}
