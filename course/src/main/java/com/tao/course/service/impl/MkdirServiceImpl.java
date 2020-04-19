package com.tao.course.service.impl;


import com.tao.course.mapper.MkdirMapper;
import com.tao.course.service.MkdirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/7 16:49
 **/
@Service
public class MkdirServiceImpl  implements MkdirService {

    @Autowired
    private MkdirMapper mkdirMapper;
}
