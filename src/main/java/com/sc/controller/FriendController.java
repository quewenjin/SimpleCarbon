package com.sc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.entity.FriendSystem;
import com.sc.entity.User;
import com.sc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FriendController extends BaseController{
    private final UserService userService;
    private final FriendSystemService friendSystemService;
    private final TrendService trendService;

    public FriendController(UserService userService, FriendSystemService friendSystemService, TrendService trendService) {
        this.userService = userService;
        this.friendSystemService = friendSystemService;
        this.trendService = trendService;
    }

    /**
     * 关注 *
     * @param params 用户账号 + 好友账号
     * @return 是否成功
     */
    @RequestMapping(value = "/followSomeone", method = RequestMethod.POST)
    public String followSomeone(@RequestBody Map<String, Object> params){
        String userId = params.get("userId").toString();
        String friendId = params.get("friendId").toString();

        JSONObject json = new JSONObject();
        FriendSystem theRelation = friendSystemService.getByUAndF(userId, friendId);
        if (theRelation == null){
            friendSystemService.creatRelationship(userId, friendId);
            json.put("state", "1");
        } else {
            json.put("state", "0");
        }
        return json.toString();
    }

    /**
     * 得到好友列表 *
     * @param params 用户账号
     * @return 名字 + 他的积分 + 是否关注 + 头像 + 他的账号
     */
    @RequestMapping(value = "/getFriends", method = RequestMethod.POST)
    public String getFriends(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();

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
        return jsonArray.toString();
    }

    /**
     * 好友动态 *
     * @param params 用户账号
     * @return 好友名字 + 好友分数 + 是否关注 + 好友头像 + 好友账号 + 好友个性签名 + url + 动态图片
     */
    @RequestMapping(value = "/SocialUpdates", method = RequestMethod.POST)
    public String SocialUpdates(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();

        String theTrend = "https://pic.downk.cc/item/5ec11edec2a9a83be5513c45.jpg";//无动态时的默认图片

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
        return theAll.toString();
    }

}
