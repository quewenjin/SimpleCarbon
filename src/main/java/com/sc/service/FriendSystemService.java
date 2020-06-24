package com.sc.service;

import com.sc.entity.FriendSystem;
import com.sc.mapper.FriendSystemMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FriendSystemService {
    @Autowired
    FriendSystemMapper friendSystemMapper;

    /**
     * 得到该用户名的所有好友的id
     * @param userId
     * @return
     */
    public List<String> getFriendIdsByUserId(String userId){
        return friendSystemMapper.getFriendIdsByUserId(userId);
    }

    /**
     * 关注
     * @param userId
     * @param friendId
     */
    public void creatRelationship(String userId, String friendId){
        friendSystemMapper.creatRelationship(userId, friendId);
    }

    /**
     * 确定关系是否存在
     * @param userId
     * @param friendId
     * @return
     */
    public FriendSystem getByUAndF(String userId, String friendId){
        return friendSystemMapper.getByUAndF(userId, friendId);
    }
}
