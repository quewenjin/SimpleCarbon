package com.sc.service;

import com.sc.entity.FriendSystem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendSystemService {
    /**
     * 得到该用户名的所有好友的id
     * @param userId
     * @return
     */
    List<String> getFriendIdsByUserId(String userId);

    /**
     * 关注
     * @param userId
     * @param friendId
     */
    void creatRelationship(String userId, String friendId);

    /**
     * 确定关系是否存在
     * @param userId
     * @param friendId
     * @return
     */
    FriendSystem getByUAndF(String userId, String friendId);
}
