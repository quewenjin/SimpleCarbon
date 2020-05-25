package com.sc.dao;

import com.sc.entity.FriendSystem;
import com.sc.entity.ScoreRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendSystemDao {
    /**
     * 得到该用户名的所有好友的id
     * @param userId
     * @return
     */
    List<String> getFriendIdsByUserId(@Param("userId")String userId);

    /**
     * 关注
     * @param userId
     * @param friendId
     */
    void creatRelationship(@Param("userId")String userId, @Param("friendId")String friendId);

    /**
     * 确定关系是否存在
     * @param userId
     * @param friendId
     * @return
     */
    FriendSystem getByUAndF(@Param("userId")String userId, @Param("friendId")String friendId);
}
