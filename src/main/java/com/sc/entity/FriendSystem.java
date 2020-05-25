package com.sc.entity;

public class FriendSystem {
    private String userId;
    private String friendId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    @Override
    public String toString() {
        return "FriendSystem{" +
                ", userId=" + userId +
                ", friendId=" + friendId +
                '}';
    }
}
