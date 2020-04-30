package com.tao.manage.service;

import com.github.pagehelper.PageInfo;
import com.tao.manage.bean.Announce;

public interface AnnounceService {
    void deleteAnnounceById(Integer announceId);

    PageInfo<Announce> getAnnuouce(Integer page, Integer row);

    void save(Announce announce);
}
