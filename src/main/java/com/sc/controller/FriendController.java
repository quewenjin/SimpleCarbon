package com.sc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.entity.FriendSystem;
import com.sc.entity.User;
import com.sc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private FriendSystemService friendSystemService;
    @Autowired
    private TrendService trendService;

    /**
     * 关注 *
     * @param userId
     * @param friendId
     * @return
     */
    @RequestMapping(value = "/followSomeone", produces = "text/plain;charset=utf-8")
    public String followSomeone(String userId, String friendId){
        JSONObject json = new JSONObject();
        FriendSystem theRelation = friendSystemService.getByUAndF(userId, friendId);
        if (theRelation == null){
            friendSystemService.creatRelationship(userId, friendId);
            json.put("state", "1");
        } else {
            json.put("state", "0");
        }
        String strJsont = json.toString();
        return strJsont;
    }

    /**
     * 得到好友列表 *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getFriends", produces = "text/plain;charset=utf-8")
    public String getFriends(String id){
        //创建JSONArray实例
        JSONArray jsonArray = new JSONArray();
        List<String> friendIds = friendSystemService.getFriendIdsByUserId(id);
        if (friendIds.size() == 0){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            jsonArray.add(jo);
        } else {
            for(String friendId: friendIds) {
                User user = userService.getUserByUserId(friendId);
                JSONObject jo = new JSONObject();
                jo.put("name", user.getUserName());
                jo.put("totals", user.getUserScore());
                jo.put("isFollowed", "1");
                jo.put("avantar", user.getUserPhoto());
                jo.put("friendId", friendId);
                jsonArray.add(jo);
            }
        }
        String json = jsonArray.toString();
        return json;
    }

    /**
     * 好友动态 *
     * @param id
     * @return
     */
    @RequestMapping(value = "/SocialUpdates", produces = "text/plain;charset=utf-8")
    public String SocialUpdates(String id){

        String theTrend = "123456789";//无动态时的默认图片

        JSONArray theAll = new JSONArray();
        List<String> friendIds = friendSystemService.getFriendIdsByUserId(id);
        if (friendIds.size() == 0){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            theAll.add(jo);
        } else {
            for (String friendId: friendIds){
                JSONObject json = new JSONObject();
                User friend = userService.getUserByUserId(friendId);
                json.put("name", friend.getUserName());
                json.put("total", friend.getUserScore());
                json.put("isFollowed", "1");
                json.put("avantar", friend.getUserPhoto());
                json.put("friendId", friendId);
                json.put("slogn", friend.getUserSlogn());
                JSONArray jsonArray = new JSONArray();
                List<String> trends = trendService.getTrendPicture(friendId);
                if (trends.size() == 0){
                    JSONObject jo = new JSONObject();
                    jo.put("url", theTrend);
                    jsonArray.add(jo);
                    json.put("images", jsonArray);
                } else {
                    for (String trend: trends){
                        System.out.println(trend);
                        JSONObject jo = new JSONObject();
                        jo.put("url", trend);
                        jsonArray.add(jo);
                    }
                    json.put("images", jsonArray);
                }
                theAll.add(json);
            }
        }
        String strJsont = theAll.toString();
        return strJsont;
    }

}
