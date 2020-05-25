package com.sc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.entity.User;
import com.sc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankController {
    @Autowired
    private UserService userService;
    @Autowired
    private ExchangeRecordService exchangeRecordService;
    @Autowired
    private FriendSystemService friendSystemService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ScoreRecordService scoreRecordService;
    @Autowired
    private TrendService trendService;

    /**
     * 全国前10 *
     * @return
     */
    @RequestMapping(value = "/countryTop10", produces = "text/plain;charset=utf-8")
    public String getCountryTop10(String id){

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
        String json = jsonArray.toString();
        return json;
    }

    /**
     * 全国前10 *
     * @return
     */
    @RequestMapping(value = "/cityTop10", produces = "text/plain;charset=utf-8")
    public String getCityTop10(String id){

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
        String json = jsonArray.toString();
        return json;
    }

    /**
     * 好友前10 *
     * @return
     */
    @RequestMapping(value = "/friendTop10", produces = "text/plain;charset=utf-8")
    public String getFriendTop10(String id){

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
        String json = jsonArray.toString();
        return json;
    }
}
