package com.young.application.controller;

import com.young.application.business.user.UserService;
import com.young.application.entity.User;
import com.young.application.system.request.ResultInfo;
import com.young.application.system.request.UserBean;
import com.young.application.system.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huiyangchen1 on 2017/6/16.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String tologin(HttpServletRequest request){


        return "login";
    }
    @RequestMapping("/{mainPage}")
    public String login(@PathVariable("mainPage") String mainPage,HttpServletRequest request){

        if(StringUtils.isEmpty(mainPage)){
            mainPage = "login";
        }
        return mainPage;
    }


    @RequestMapping("/{moudle}/to/{page}")
    public String toLogin(@PathVariable("moudle") String moudle,@PathVariable("page") String page, HttpServletRequest request){

        return moudle+"/"+page;
    }


    @RequestMapping("/login/validate")
    @ResponseBody
    public ResultInfo loginInfo(UserBean bean, HttpServletRequest request){
        ResultInfo info = new ResultInfo();
        User userInfo = userService.findUserInfo(bean.getUserName(), Md5Util.MD5Encode(bean.getPassword()));
        if(userInfo == null){
            info.setCode(2);
            info.setDesc("用户名或密码错误");
        }

        return info;
    }
}
