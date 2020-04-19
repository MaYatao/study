package com.tao.manage.service.impl;


import com.tao.manage.mapper.SkillMapper;
import com.tao.manage.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillMapper skillMapper;
}
