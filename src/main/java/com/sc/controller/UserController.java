package com.sc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.entity.ScoreRecord;
import com.sc.entity.User;
import com.sc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class UserController extends BaseController{
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
     * 今日积分数据 *
     * @param id
     * @return
     */
    @RequestMapping(value = "/ScoreData", produces = "text/plain;charset=utf-8")
    public String Test(String id){

        String theTrend = "https://pic.downk.cc/item/5ec11c15c2a9a83be54e521b.jpg";//无动态时的默认图片

        JSONObject json = new JSONObject();
        User theUser = userService.getUserByUserId(id);
        if (theUser == null){
            json.put("state", "0");
        } else {
            json.put("state", "1");

            json.put("userScore", theUser.getUserScore());
            json.put("userAccount", theUser.getUserAccount());
            json.put("walkToday", theUser.getWalkToday());//步
            json.put("busToday", theUser.getBusToday());//次
            json.put("shopToday", theUser.getShopToday());//次
            json.put("walkGoal", 5000);//步
            json.put("busGoal", 2);//次
            json.put("shopGoal", 1);//次
            JSONArray jsonArray = new JSONArray();
            List<String> trends = trendService.getTrendPicture(id);
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
        }
        String strJsont = json.toString();
        return strJsont;
    }

    /**
     * 查询某用户某天的积分记录 *
     * @param id
     * @param date
     * @return
     */
    @RequestMapping(value = "/getScoreForDay", produces = "text/plain;charset=utf-8")
    public String getScoreForDay(String id, String date){
        //创建JSONArray实例
        JSONArray jsonArray = new JSONArray();
        List<ScoreRecord> scoreRecords = scoreRecordService.checkScoreForDay(id, date);
        if (scoreRecords.size() == 0){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            jsonArray.add(jo);
        } else {
            for(ScoreRecord scoreRecord: scoreRecords) {
                JSONObject jo = new JSONObject();
                jo.put("scoreRecordTime", scoreRecord.getScoreRecordTime());
                jo.put("scoreRecordType", scoreRecord.getScoreRecordType());
                jo.put("scoreRecordNum", scoreRecord.getScoreRecordNum());
                jsonArray.add(jo);
            }
        }

        String json = jsonArray.toString();
        System.out.println(json);
        return json;
    }

    /**
     * 查询某用户本日的积分记录 *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getScoreForToday", produces = "text/plain;charset=utf-8")
    public String getScoreForToday(String id){
        //创建JSONArray实例
        JSONArray jsonArray = new JSONArray();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowDate = df.format(new Date());
        List<ScoreRecord> scoreRecords = scoreRecordService.checkScoreForDay(id, nowDate);
        if (scoreRecords.size() == 0){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            jsonArray.add(jo);
        } else {
            for(ScoreRecord scoreRecord: scoreRecords) {
                JSONObject jo = new JSONObject();
                jo.put("scoreRecordTime", scoreRecord.getScoreRecordTime());
                jo.put("scoreRecordType", scoreRecord.getScoreRecordType());
                jo.put("scoreRecordNum", scoreRecord.getScoreRecordNum());
                jsonArray.add(jo);
            }
        }
        String json = jsonArray.toString();
        System.out.println(json);
        return json;
    }

    /**
     * 查询某用户本周的积分记录 *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getScoreForWeek", produces = "text/plain;charset=utf-8")
    public String getScoreForWeek(String id){
        //创建JSONArray实例
        JSONArray jsonArray = new JSONArray();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowDate = sdf.format(new Date());
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        // 此时的cal为本周的星期一
        // 系统计算为星期天开始，例：星期三为本周的第四天
        for (int i = 0; i < day-2 ; i++) {
            cal.add(Calendar.DATE, i);
            String theDate = sdf.format(cal.getTime());
//            System.out.println(theDate);
            List<ScoreRecord> scoreRecords = scoreRecordService.checkScoreForDay(id, theDate);
            if (scoreRecords.size() == 0){
                JSONObject jo = new JSONObject();
                jo.put("state", "0");
                jsonArray.add(jo);
            } else {
                for(ScoreRecord scoreRecord: scoreRecords) {
                    JSONObject jo = new JSONObject();
                    jo.put("scoreRecordTime", scoreRecord.getScoreRecordTime());
                    jo.put("scoreRecordType", scoreRecord.getScoreRecordType());
                    jo.put("scoreRecordNum", scoreRecord.getScoreRecordNum());
                    jsonArray.add(jo);
                }
            }
        }
        List<ScoreRecord> scoreRecords = scoreRecordService.checkScoreForDay(id, nowDate);
        if (scoreRecords.size() == 0){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            jsonArray.add(jo);
        } else{
            for(ScoreRecord scoreRecord: scoreRecords) {
                JSONObject jo = new JSONObject();
                jo.put("scoreRecordTime", scoreRecord.getScoreRecordTime());
                jo.put("scoreRecordType", scoreRecord.getScoreRecordType());
                jo.put("scoreRecordNum", scoreRecord.getScoreRecordNum());
                jsonArray.add(jo);
            }
        }
        String json = jsonArray.toString();
        System.out.println(json);
        return json;
    }

    /**
     * 查询某用户本月的积分记录 *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getScoreForMonth", produces = "text/plain;charset=utf-8")
    public String getScoreForMonth(String id){
        //创建JSONArray实例
        JSONArray jsonArray = new JSONArray();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowDate = sdf.format(new Date());
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        calendar.add(Calendar.DATE, 1);
        String theDate = sdf.format(calendar.getTime());
        while ( !theDate.equals(nowDate) ){
            //System.out.println(theDate);
            List<ScoreRecord> scoreRecords = scoreRecordService.checkScoreForDay(id, theDate);
            if (scoreRecords.size() == 0){
                JSONObject jo = new JSONObject();
                jo.put("state", "0");
                jsonArray.add(jo);
            } else {
                for(ScoreRecord scoreRecord: scoreRecords) {
                    JSONObject jo = new JSONObject();
                    jo.put("scoreRecordTime", scoreRecord.getScoreRecordTime());
                    jo.put("scoreRecordType", scoreRecord.getScoreRecordType());
                    jo.put("scoreRecordNum", scoreRecord.getScoreRecordNum());
                    jsonArray.add(jo);
                }
            }
            calendar.add(Calendar.DATE, 1);
            theDate = sdf.format(calendar.getTime());
        }
        List<ScoreRecord> scoreRecords = scoreRecordService.checkScoreForDay(id, theDate);
        if (scoreRecords.size() == 0){
            JSONObject jo = new JSONObject();
            jo.put("state", "0");
            jsonArray.add(jo);
        } else {
            for(ScoreRecord scoreRecord: scoreRecords) {
                JSONObject jo = new JSONObject();
                jo.put("scoreRecordTime", scoreRecord.getScoreRecordTime());
                jo.put("scoreRecordType", scoreRecord.getScoreRecordType());
                jo.put("scoreRecordNum", scoreRecord.getScoreRecordNum());
                jsonArray.add(jo);
            }
        }
        String json = jsonArray.toString();
        System.out.println(json);
        return json;
    }

}
