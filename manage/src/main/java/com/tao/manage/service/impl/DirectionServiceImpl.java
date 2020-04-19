package com.tao.manage.service.impl;

import com.tao.manage.mapper.DirectionMapper;
import com.tao.manage.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionMapper directionMapper;
}
