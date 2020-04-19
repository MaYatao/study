package com.tao.blog.service.impl;

import com.tao.blog.bean.Fans;
import com.tao.blog.mapper.FansMapper;
import com.tao.blog.service.FansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 17:30
 **/
@Service
public class FansServiceImpl implements FansService {

    @Autowired
    private  FansMapper  fansMapper;
    public List<Fans> get(){
        return  fansMapper.selectAll();
    }
}
