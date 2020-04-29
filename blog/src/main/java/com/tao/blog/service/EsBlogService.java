package com.tao.blog.service;

import com.tao.blog.bean.Content;


import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/29 14:54
 */
public interface EsBlogService {
    public void addContent(Content content);
    public void deletedContentById(String id);
    public void updateContent(Content couerses) ;
    public List<Content> queryByTitle(String title) ;
}
