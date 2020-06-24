package com.sc.controller;

import com.alibaba.fastjson.JSONObject;
import com.sc.entity.User;
import com.sc.service.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class ExchangeController {
    private final UserService userService;
    private final ScoreRecordService scoreRecordService;

    public ExchangeController(UserService userService, ScoreRecordService scoreRecordService) {
        this.userService = userService;
        this.scoreRecordService = scoreRecordService;
    }

    /**
     * 实时查询积分和余额
     * @param params 账号
     * @return 钱余额 + 积分余额
     */
    @RequestMapping(value = "/userWallet", method = RequestMethod.POST)
    public String Test(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();

        JSONObject json = new JSONObject();
        User user = userService.getUserByUserId(id);
        json.put("score", user.getUserScore());
        json.put("account", user.getUserAccount());
        return json.toString();
    }

    /**
     * 积分换商品
     * @param params 账号 + 金额
     * @return 是否成功 + 余额
     */
    @RequestMapping(value = "/changeScoreToProduct", method = RequestMethod.POST)
    public String scoreToProduct(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();
        int num = Integer.parseInt(params.get("num").toString());

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
        return json.toString();
    }

    /**
     * 积分捐赠
     * @param params 账号 + 金额
     * @return 是否成功 + 余额
     */
    @RequestMapping(value = "/changeScoreToDonate", method = RequestMethod.POST)
    public String scoreToDonate(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();
        int num = Integer.parseInt(params.get("num").toString());

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
        return json.toString();
    }

    /**
     * 余额换商品
     * @param params 账号 + 金额
     * @return 是否成功 + 余额
     */
    @RequestMapping(value = "/changeAccountToProduct", method = RequestMethod.POST)
    public String accountToProduct(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();
        float num = Float.parseFloat(params.get("num").toString());

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
        return json.toString();
    }

    /**
     * 积分换余额
     * @param params 账号 + 比例 + 比例 + 数量
     * @return  是否成功 + 钱余额 + 积分余额
     */
    @RequestMapping(value = "/changeScoreToAccount", method = RequestMethod.POST)
    public String ScoreToAccount(@RequestBody Map<String, Object> params){
        String id = params.get("id").toString();
        int scoreRate = Integer.parseInt(params.get("scoreRate").toString());
        float accountRate = Float.parseFloat(params.get("accountRate").toString());
        int num = Integer.parseInt(params.get("num").toString());

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
        return json.toString();
    }


}
