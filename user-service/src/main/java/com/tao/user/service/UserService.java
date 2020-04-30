package com.tao.user.service;

import com.github.pagehelper.PageInfo;
import com.tao.user.bean.User;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:17
 **/
public interface UserService {
    public   void  save(User user);
    public User getUserByName(String name);
    public User getUserById(int id);
    public   User  login(User user);
    public PageInfo<User> getUserList(Integer page, Integer row);

    public void edit(User user);


    void deleteUserById(Integer userId);
}
