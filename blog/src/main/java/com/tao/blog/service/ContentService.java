package com.tao.blog.service;
import com.github.pagehelper.PageInfo;
import com.tao.blog.bean.Content;
import com.tao.blog.bean.BlogResult;

public interface ContentService {
    public void  save(Content content);

    public void edit(Content content);
    public PageInfo<BlogResult> getHotArticle(Integer page, Integer row ,Integer  type) ;
    public PageInfo<BlogResult> getLastArticle(Integer page, Integer row ,Integer  type) ;
    public PageInfo<BlogResult> getArticleByUid(Integer userId, Integer status, Integer page, Integer row) ;
    public  void  deleteArticleByCid(Integer contentId, Integer userId) throws Exception;

   public BlogResult getArticleById(Integer contentId);
}
