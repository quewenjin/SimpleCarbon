package com.sc.controller;

import com.alibaba.fastjson.JSONObject;
import com.sc.entity.User;
import com.sc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ExchangeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ExchangeRecordService exchangeRecordService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ScoreRecordService scoreRecordService;

    /**
     * 实时查询积分和余额
     * @param id
     * @return
     */
    @RequestMapping(value = "/userWallet", produces = "text/plain;charset=utf-8")
    public String Test(String id){
        JSONObject json = new JSONObject();
        User user = userService.getUserByUserId(id);
        json.put("score", user.getUserScore());
        json.put("account", user.getUserAccount());
        String strJsont = json.toString();
        return strJsont;
    }

    /**
     * 积分换商品
     * @param id
     * @param num
     * @return
     */
    @RequestMapping(value = "/changeScoreToProduct", produces = "text/plain;charset=utf-8")
    public String scoreToProduct(String id, int num){
        JSONObject json = new JSONObject();
        User user = userService.getUserByUserId(id);
        int score = user.getUserScore();
        json.put("before", score);
        score = score - num;
        if (score >= 0){
            //账户扣除积分
            userService.setScoreById(id, score);
            json.put("state", "1");
            json.put("after", score);
            //积分记录
            String type = "积分交易";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String nowDate = sdf.format(new Date());
            int sub = 0 - num;
            scoreRecordService.creatScoreRecordToday(id, nowDate, type, sub);
            //交易记录 ......
        } else {
            json.put("state", "0");//余额不足
            json.put("after", score + num);
        } // else 库存问题 ......
        String strJsont = json.toString();
        return strJsont;
    }

    /**
     * 积分捐赠
     * @param id
     * @param num
     * @return
     */
    @RequestMapping(value = "/changeScoreToDonate", produces = "text/plain;charset=utf-8")
    public String scoreToDonate(String id, int num){
        JSONObject json = new JSONObject();
        User user = userService.getUserByUserId(id);
        int score = user.getUserScore();
        json.put("before", score);
        score = score - num;
        if (score >= 0){
            //账户扣除积分
            userService.setScoreById(id, score);
            json.put("state", "1");
            json.put("after", score);
            //积分记录
            String type = "积分捐赠";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String nowDate = sdf.format(new Date());
            int sub = 0 - num;
            scoreRecordService.creatScoreRecordToday(id, nowDate, type, sub);
            //交易记录 ......
        } else {
            json.put("state", "0");//余额不足
            json.put("after", score + num);
        } // else 库存问题 ......
        String strJsont = json.toString();
        return strJsont;
    }

    /**
     * 余额换商品
     * @param id
     * @param num
     * @return
     */
    @RequestMapping(value = "/changeAccountToProduct", produces = "text/plain;charset=utf-8")
    public String accountToProduct(String id, float num){
        JSONObject json = new JSONObject();
        User user = userService.getUserByUserId(id);
        float account = user.getUserAccount();
        json.put("before", account);
        account = account - num;
        if (account >= 0){
            //账户扣除积分
            userService.setAccountById(id, account);
            json.put("state", "1");
            json.put("after", account);
            //交易记录 ......
        } else {
            json.put("state", "0");//余额不足
            json.put("after", account + num);
        } // else 库存问题 ......
        String strJsont = json.toString();
        return strJsont;
    }

    //积分换余额
    @RequestMapping(value = "/changeScoreToAccount", produces = "text/plain;charset=utf-8")
    public String ScoreToAccount(String id, int scoreRate, float accountRate, int num){
        JSONObject json = new JSONObject();
        User user = userService.getUserByUserId(id);
        int score = user.getUserScore();
        float account = user.getUserAccount();
        json.put("beforeScore", score);
        json.put("beforeAccount", account);
        float rate = accountRate/scoreRate;
        if (num > score){
            json.put("state", "0");
            json.put("afterScore", score);
            json.put("afterAccount", account);
        } else {
            json.put("state", "1");
            score = score - num;
            account = account + num*rate;
            userService.setScoreById(id, score);
            userService.setAccountById(id, account);
            json.put("afterScore", score);
            json.put("afterAccount", account);
            //积分记录
            String type = "积分交易";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String nowDate = sdf.format(new Date());
            int sub = 0 - num;
            scoreRecordService.creatScoreRecordToday(id, nowDate, type, sub);
        }
        String strJsont = json.toString();
        return strJsont;
    }


}
