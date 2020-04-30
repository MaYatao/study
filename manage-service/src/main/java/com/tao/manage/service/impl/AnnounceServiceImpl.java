package com.tao.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tao.manage.bean.Announce;
import com.tao.manage.mapper.AnnounceMapper;
import com.tao.manage.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {

    @Autowired
    private AnnounceMapper announceMapper ;

    @Override
    public void deleteAnnounceById(Integer announceId) {
        announceMapper.deleteByPrimaryKey(announceId);
    }

    @Override
    public PageInfo<Announce> getAnnuouce(Integer page, Integer row) {
        List<Announce> announces =announceMapper.selectAll();
        PageHelper.startPage(page,row);
        PageInfo<Announce> pages = new PageInfo<Announce>(announces);
        return pages;
    }

    @Override
    public void save(Announce announce) {
        announceMapper.insert(announce);
    }
}
