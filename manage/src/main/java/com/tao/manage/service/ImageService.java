package com.tao.manage.service;

import com.github.pagehelper.PageInfo;
import com.tao.manage.bean.Image;

public interface ImageService {
    void deleteImageById(Integer imageId);

    PageInfo<Image> getImage(Integer page, Integer row);

    void save(Image iamge);
}
