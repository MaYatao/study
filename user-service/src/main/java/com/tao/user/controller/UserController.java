package com.tao.user.controller;

import com.github.pagehelper.PageInfo;
import com.tao.common.utils.AIResult;
import com.tao.user.bean.User;
import com.tao.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:23
 **/
@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/student/register", method = RequestMethod.POST)
    @ResponseBody
    public AIResult saveUser(User user) {
        user.setIdentity(0);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        user.setJoinDay(dateString);
        System.out.println(user);
        try {
            userService.save(user);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("注册成功");
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AIResult login(User user) {
        System.out.println(user);
        try {
            User u = userService.login(user);
            u.setPassword("");
            return AIResult.build(200, "登陆成功", u);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    public AIResult getUserById(int userId) {

        try {
            User user = userService.getUserById(userId);
            return AIResult.ok(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    @ResponseBody
    public AIResult editUser(User user) {
        try {
            userService.edit(user);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("修改成功");
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public AIResult getUserList(Integer page, Integer row) {

        try {
            PageInfo<User> userList = (PageInfo<User>) userService.getUserList(page, row);
            return AIResult.ok(userList);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }

    }

    @RequestMapping(value = "/deleteUserById")
    @ResponseBody
    public AIResult deleteUserById(Integer userId) {
        try {
            userService.deleteUserById(userId);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("注册成功");
    }
}
