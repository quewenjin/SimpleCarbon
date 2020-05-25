package com.sc.controller;

import com.alibaba.fastjson.JSONObject;
import com.sc.entity.User;
import com.sc.service.ScoreRecordService;
import com.sc.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class LoginController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private ScoreRecordService scoreRecordService;

    /**
     * 登录验证 *
     * @param id 账号
     * @param password 密码
     */
    @RequestMapping(value = "/login", produces = "text/plain;charset=utf-8")
    public String LoginVerify(String id, String password){
        JSONObject json = new JSONObject();
        List<User> users = userService.getUsersByIAndP(id, password);//账号+密码
        if (users.size() == 0){
            json.put("state", "0");//错误
        } else {
            json.put("state", "1");//登陆成功
            for(User user: users){
                json.put("userId", user.getUserId());
                json.put("userName", user.getUserName());
                json.put("userShake", user.getUserSlogn());//个性签名
                json.put("userPhoto", user.getUserPhoto());
                json.put("userCheck", user.getUserCheck());
            }

            //设置模拟数据
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String nowDate = df.format(new Date());
            String lastDate = userService.getTodayOfId(id);
            int theScore = userService.getScoreById(id);
            int theNum = 0;
            String type = "";
            if (nowDate.equals(lastDate)){
                json.put("dataEdit","0");//没必要修改
            } else {
                Random r = new Random(1);
                int ran1 = r.nextInt(10000);
                int ran2 = r.nextInt(3);
                int ran3 = r.nextInt(3);
                userService.setTodayData(id, ran1, ran2, ran3, nowDate);
                //设置一下记录（先休息一下，等下回来写）
                if (ran1 >= 5000){
                    theScore = theScore + 5;
                    theNum = 5;
                    type = "步行";
                    scoreRecordService.creatScoreRecordToday(id, nowDate, type, theNum);
                }
                if (ran2 >= 2){
                    theScore = theScore + 2;
                    theNum = 2;
                    type = "公交";
                    scoreRecordService.creatScoreRecordToday(id, nowDate, type, theNum);
                } else if (ran2 == 1) {
                    theScore = theScore + 1;
                    theNum = 1;
                    type = "公交";
                    scoreRecordService.creatScoreRecordToday(id, nowDate, type, theNum);
                }
                if (ran3 >= 1){
                    theScore = theScore + 1;
                    theNum = 1;
                    type = "绿色购物";
                    scoreRecordService.creatScoreRecordToday(id, nowDate, type, theNum);
                }
                userService.setScoreById(id, theScore);
                json.put("dataEdit","1");//修改成功
            }
        }
        //控制台输出
        String strJsont = json.toString();
        return strJsont;
    }

    /**
     * 注册 *
     * @param id
     * @param password
     * @return
     */
    @RequestMapping(value = "/register", produces = "text/plain;charset=utf-8")
    public String Register(@Param("id") String id, @Param("password") String password){
        //创建JSONobject实例
        JSONObject json = new JSONObject();
        List<User> users = userService.getUsersByUserId(id);
        if (users.size()!=0 ){
            json.put("state","0");//用户名重复
        } else {
            userService.creatUser(id, password);//注册
            json.put("state","1");//注册成功
        }
        String strJsont = json.toString();
        return strJsont;
    }

}
