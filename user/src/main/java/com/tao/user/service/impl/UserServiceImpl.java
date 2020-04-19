package com.tao.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tao.user.bean.User;
import com.tao.user.mapper.UserMapper;
import com.tao.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:21
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {

        User u = getUserByName(user.getUsername());
        if (u !=null) {
            throw new RuntimeException("该用户名已注册");
        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByName(String name) {
        User user=new User();
        user.setUsername(name);
        return userMapper.selectOne(user);
    }

    @Override
    public User login(User user) {
     User   u =getUserByName(user.getUsername());
        if(u==null){
            throw  new RuntimeException("用户名错误");
        }
        if(!u.getPassword().equals(user.getPassword())){
            throw  new RuntimeException("密码错误");
        }
        return u;
    }

    @Override
    public PageInfo<User> getUserList(Integer page, Integer row) {
        List<User> list = userMapper.selectAll();
        PageHelper.startPage(page,row);
        PageInfo<User> pages = new PageInfo<User>(list);
        return pages;
    }

    @Override
    public void edit(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }


    @Override
    public void deleteUserById(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }
}
