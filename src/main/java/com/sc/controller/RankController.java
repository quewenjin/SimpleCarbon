package com.sc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.entity.User;
import com.sc.service.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RankController {
    private final UserService userService;
    private final FriendSystemService friendSystemService;
    private final TrendService trendService;

    public RankController(UserService userService, FriendSystemService friendSystemService, TrendService trendService) {
        this.userService = userService;
        this.friendSystemService = friendSystemService;
        this.trendService = trendService;
    }

    /**
     * 全国前10 *
     * @param params 用户账号
     * @return 排名 + 名字 + 积分 + 是否关注 + 头像 + 账号 + 个性签名 + url + 动态图片
     */
    @RequestMapping(value = "/countryTop10", method = RequestMethod.POST)
    public String getCountryTop10(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();

        String theTrend = "https://pic.downk.cc/item/5ec11c15c2a9a83be54e521b.jpg";//无动态时的默认图片

        //创建JSONArray实例
        JSONArray jsonArray = new JSONArray();
        User that = userService.getUserByUserId(id);
        if (that == null){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            jsonArray.add(jo);
        } else {
            List<String> friendIds = friendSystemService.getFriendIdsByUserId(id);
            for (String friendId: friendIds){
                userService.setFriendIdById(friendId, id);
            }
            int rank = 1;
            List<User> users = userService.getCountryTop10();
            for(User user: users) {
                JSONObject jo = new JSONObject();
                jo.put("ranking", rank);
                jo.put("name", user.getUserName());
                jo.put("totals", user.getUserScore());
                if (id.equals(user.getTheFriendId()) || id.equals(user.getUserId())){
                    jo.put("isFollowed", "1");
                } else {
                    jo.put("isFollowed", "0");
                }
                jo.put("avantar", user.getUserPhoto());
                String theId = user.getUserId();
                jo.put("friendId", theId);
                jo.put("slogn", user.getUserSlogn());
                JSONArray theArray = new JSONArray();
                List<String> trends = trendService.getTrendPicture(theId);
                if (trends.size() == 0){
                    JSONObject jojo = new JSONObject();
                    jojo.put("url", theTrend);
                    theArray.add(jojo);
                    jo.put("images", theArray);
                } else {
                    for (String trend: trends){
                        System.out.println(trend);
                        JSONObject jojo = new JSONObject();
                        jojo.put("url", trend);
                        theArray.add(jojo);
                    }
                    jo.put("images", theArray);
                }
                jsonArray.add(jo);
                rank++;
            }
            String instead = "";
            for (String friendId: friendIds){
                userService.setFriendIdById(friendId, instead);
            }
        }
        return jsonArray.toString();
    }

    /**
     * 全国前10 *
     * @param params 用户账号
     * @return 排名 + 名字 + 积分 + 是否关注 + 头像 + 账号 + 个性签名 + url + 动态图片
     */
    @RequestMapping(value = "/cityTop10", method = RequestMethod.POST)
    public String getCityTop10(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();

        String theTrend = "https://pic.downk.cc/item/5ec11c15c2a9a83be54e521b.jpg";//无动态时的默认图片

        //创建JSONArray实例
        JSONArray jsonArray = new JSONArray();
        User that = userService.getUserByUserId(id);
        if (that == null){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            jsonArray.add(jo);
        } else{
            List<String> friendIds = friendSystemService.getFriendIdsByUserId(id);
            for (String friendId: friendIds){
                userService.setFriendIdById(friendId, id);
            }
            int rank = 1;
            User theUser = userService.getUserByUserId(id);
            String cityName = theUser.getUserCity();

            List<User> users = userService.getCityTop10(cityName);

            for(User user: users) {
                JSONObject jo = new JSONObject();
                jo.put("ranking", rank);
                jo.put("name", user.getUserName());
                jo.put("totals", user.getUserScore());
                if (id.equals(user.getTheFriendId()) || id.equals(user.getUserId())){
                    jo.put("isFollowed", "1");
                } else {
                    jo.put("isFollowed", "0");
                }
                jo.put("avantar", user.getUserPhoto());
                String theId = user.getUserId();
                jo.put("friendId", theId);
                jo.put("slogn", user.getUserSlogn());
                JSONArray theArray = new JSONArray();
                List<String> trends = trendService.getTrendPicture(theId);
                if (trends.size() == 0){
                    JSONObject jojo = new JSONObject();
                    jojo.put("url", theTrend);
                    theArray.add(jojo);
                    jo.put("images", theArray);
                } else {
                    for (String trend: trends){
                        System.out.println(trend);
                        JSONObject jojo = new JSONObject();
                        jojo.put("url", trend);
                        theArray.add(jojo);
                    }
                    jo.put("images", theArray);
                }
                jsonArray.add(jo);
                rank++;
            }
            String instead = "";
            for (String friendId: friendIds){
                userService.setFriendIdById(friendId, instead);
            }
        }
        return jsonArray.toString();
    }

    /**
     * 好友前10 *
     * @param params 用户账号
     * @return 排名 + 名字 + 积分 + 是否关注 + 头像 + 账号 + 个性签名 + url + 动态图片
     */
    @RequestMapping(value = "/friendTop10", method = RequestMethod.POST)
    public String getFriendTop10(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();

        String theTrend = "https://pic.downk.cc/item/5ec11c15c2a9a83be54e521b.jpg";//无动态时的默认图片

        //创建JSONArray实例
        JSONArray jsonArray = new JSONArray();
        List<String> friendIds = friendSystemService.getFriendIdsByUserId(id);
        User that = userService.getUserByUserId(id);
        if (that == null){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            jsonArray.add(jo);
        } else{
            for (String friendId: friendIds){
                userService.setFriendIdById(friendId, id);
            }
            int rank = 1;
            List<User> users = userService.getFriendTop10(id);
            for(User user: users) {
                JSONObject jo = new JSONObject();
                jo.put("ranking", rank);
                jo.put("name", user.getUserName());
                jo.put("totals", user.getUserScore());
                jo.put("isFollowed", "1");
                jo.put("avantar", user.getUserPhoto());
                String theId = user.getUserId();
                jo.put("friendId", theId);
                jo.put("slogn", user.getUserSlogn());
                JSONArray theArray = new JSONArray();
                List<String> trends = trendService.getTrendPicture(theId);
                if (trends.size() == 0){
                    JSONObject jojo = new JSONObject();
                    jojo.put("url", theTrend);
                    theArray.add(jojo);
                    jo.put("images", theArray);
                } else {
                    for (String trend: trends){
                        System.out.println(trend);
                        JSONObject jojo = new JSONObject();
                        jojo.put("url", trend);
                        theArray.add(jojo);
                    }
                    jo.put("images", theArray);
                }
                jsonArray.add(jo);
                rank++;
            }
            String instead = "";
            for (String friendId: friendIds){
                userService.setFriendIdById(friendId, instead);
            }
        }
        return jsonArray.toString();
    }

}
