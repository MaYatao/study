package com.tao.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tao.blog.bean.Comment;
import com.tao.blog.bean.Content;
import com.tao.blog.mapper.CommentMapper;
import com.tao.blog.mapper.ContentMapper;
import com.tao.blog.service.ContentService;
import com.tao.blog.pojo.BlogResult;
import com.tao.study.bean.RecordKnowledge;
import com.tao.study.mapper.RecordKnowledgeMapper;
import com.tao.user.bean.User;
import com.tao.user.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 17:35
 **/
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private RecordKnowledgeMapper recordKnowledgeMapper;

    @Override
    public void save(Content content) {
        contentMapper.insert(content);
    }

    @Override
    public void edit(Content content) {
        contentMapper.updateByPrimaryKeySelective(content);
    }

    @Override
    public BlogResult getArticleById(Integer contentId) {
        Content c = contentMapper.selectByPrimaryKey(contentId);

        User u = userMapper.selectByPrimaryKey(c.getUserId());
        BlogResult blogResult = new BlogResult();
        blogResult.setUserId(c.getUserId());
        blogResult.setContentId(c.getContentId());
        blogResult.setAgree(c.getAgree());
        blogResult.setContent(c.getContent());
        blogResult.setTitle(c.getTitle());
        blogResult.setUsername(u.getUsername());
        blogResult.setHeadImage(u.getHeadImage());
        blogResult.setCreateTime(c.getCreateTime());
        blogResult.setTopic(c.getTopic());
            blogResult.setComment(c.isComment());
        blogResult.setComments(c.getComments());
        blogResult.setStatus(c.getStatus());
        blogResult.setViews(c.getViews());
        return blogResult;
    }

    @Override
    public PageInfo<BlogResult> getHotArticle(Integer page, Integer row, Integer type) {
        Example example = new Example(Content.class);
        example.setOrderByClause("views");
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", type);
        criteria.andEqualTo("status", 0);
        List<Content> contentList = contentMapper.selectByExample(example);
        List<BlogResult> blogResultList = new ArrayList<>();
        for (Content c : contentList) {
            User u = userMapper.selectByPrimaryKey(c.getUserId());
            BlogResult blogResult = new BlogResult();
            blogResult.setUserId(c.getUserId());
            blogResult.setContentId(c.getContentId());
            blogResult.setAgree(c.getAgree());
            blogResult.setContent(c.getContent());
            blogResult.setTitle(c.getTitle());
            blogResult.setUsername(u.getUsername());
            blogResult.setComments(c.getComments());
            blogResult.setHeadImage(u.getHeadImage());
            blogResult.setCreateTime(c.getCreateTime());
            blogResult.setTopic(c.getTopic());
            blogResult.setComment(c.isComment());
            blogResult.setStatus(c.getStatus());
            blogResult.setViews(c.getViews());
            blogResultList.add(blogResult);
        }

        PageHelper.startPage(page, row);
        PageInfo<BlogResult> pages = new PageInfo<BlogResult>(blogResultList);
        return pages;
    }

    @Override
    public PageInfo<BlogResult> getLastArticle(Integer page, Integer row, Integer type) {
        Example example = new Example(Content.class);
        example.setOrderByClause("content_time");
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", 0);
        criteria.andEqualTo("type", type);
        List<Content> contentList = contentMapper.selectByExample(example);
        List<BlogResult> blogResultList = new ArrayList<>();
        for (Content c : contentList) {
            User u = userMapper.selectByPrimaryKey(c.getUserId());
            BlogResult blogResult = new BlogResult();
            blogResult.setUserId(c.getUserId());
            blogResult.setAgree(c.getAgree());
            blogResult.setContentId(c.getContentId());
            blogResult.setContent(c.getContent());
            blogResult.setTitle(c.getTitle());
            blogResult.setUsername(u.getUsername());
            blogResult.setHeadImage(u.getHeadImage());
            blogResult.setCreateTime(c.getCreateTime());
            blogResult.setType(c.getType());
            blogResult.setKnowledges1(c.getKnowledges1());
            blogResult.setComment(c.isComment());
            blogResult.setComments(c.getComments());
            blogResult.setStatus(c.getStatus());
            blogResult.setViews(c.getViews());
            blogResultList.add(blogResult);
        }

        PageHelper.startPage(page, row);
        PageInfo<BlogResult> pages = new PageInfo<BlogResult>(blogResultList);
        return pages;
    }

    @Override
    public PageInfo<BlogResult> getArticleByUid(Integer userId, Integer status, Integer page, Integer row) {
        Example example = new Example(Content.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        if (status != null) {
            criteria.andEqualTo("status", status);
        }
        List<Content> contentList = contentMapper.selectByExample(example);

        List<BlogResult> blogResultList = new ArrayList<>();
        for (Content c : contentList) {
            User u = userMapper.selectByPrimaryKey(c.getUserId());
            BlogResult blogResult = new BlogResult();
            blogResult.setUserId(c.getUserId());
            blogResult.setContentId(c.getContentId());
            blogResult.setAgree(c.getAgree());
            blogResult.setContent(c.getContent());
            blogResult.setTitle(c.getTitle());
            blogResult.setUsername(u.getUsername());
            blogResult.setHeadImage(u.getHeadImage());
            blogResult.setCreateTime(c.getCreateTime());
            blogResult.setTopic(c.getTopic());
            blogResult.setType(c.getType());
            blogResult.setKnowledges1(c.getKnowledges1());
            blogResult.setComment(c.isComment());
            blogResult.setComments(c.getComments());
            blogResult.setStatus(c.getStatus());
            blogResult.setViews(c.getViews());
            blogResultList.add(blogResult);
        }

        PageHelper.startPage(page, row);
        PageInfo<BlogResult> pages = new PageInfo<BlogResult>(blogResultList);
        return pages;
    }

    @Override
    public void deleteArticleByCid(Integer contentId, Integer userId) throws Exception {
        Content content = new Content();
        content.setContentId(contentId);
        content.setUserId(userId);
        Example example = new Example(Content.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        criteria.andEqualTo("contentId", contentId);

        if (contentMapper.deleteByExample(example) == 0) {
            System.out.println(contentMapper.delete(content) == 0);
            throw new Exception("删除失败");
        } else {
            Example example1 = new Example(Comment.class);
            Criteria criteria1 = example1.createCriteria();
            criteria.andEqualTo("contentId", contentId);
            commentMapper.deleteByExample(example1);
        }

    }
    //根据结点推荐课程
    public List<Content> recommendContent(Integer userId) {
        Example example = new Example(RecordKnowledge.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        example.orderBy("rkid");
        RowBounds rowBounds = new RowBounds(1, 10);
        List<RecordKnowledge> recordKnowledges = recordKnowledgeMapper.selectByExampleAndRowBounds(example, rowBounds);
        Example example1 = new Example(RecordKnowledge.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andIn("knowledges1", recordKnowledges);
        criteria1.andIn("knowledges2", recordKnowledges);
        criteria1.andIn("knowledges3", recordKnowledges);
        return contentMapper.selectByExample(example1);
    }

}
