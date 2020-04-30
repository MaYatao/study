package com.tao.manage.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tao.manage.bean.Image;
import com.tao.manage.mapper.ImageMapper;
import com.tao.manage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:21
 **/
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public void deleteImageById(Integer imageId) {

        imageMapper.deleteByPrimaryKey(imageId);

    }

    @Override
    public PageInfo<Image> getImage(Integer page, Integer row) {
        List<Image> images =imageMapper.selectAll();
        PageHelper.startPage(page,row);
        PageInfo<Image> pages = new PageInfo<Image>(images);
        return pages;
    }

    @Override
    public void save(Image image) {
     imageMapper.insert(image);
    }
}
