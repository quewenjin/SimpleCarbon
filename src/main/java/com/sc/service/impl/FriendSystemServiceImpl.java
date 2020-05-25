package com.sc.service.impl;

import com.sc.dao.FriendSystemDao;
import com.sc.entity.FriendSystem;
import com.sc.service.FriendSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendSystemServiceImpl implements FriendSystemService {
    @Autowired
    private FriendSystemDao friendSystemDao;

    @Override
    public List<String> getFriendIdsByUserId(String userId) {
        return friendSystemDao.getFriendIdsByUserId(userId);
    }

    @Override
    public void creatRelationship(String userId, String friendId) {
        friendSystemDao.creatRelationship(userId, friendId);
    }

    @Override
    public FriendSystem getByUAndF(String userId, String friendId) {
        return friendSystemDao.getByUAndF(userId, friendId);
    }
}
