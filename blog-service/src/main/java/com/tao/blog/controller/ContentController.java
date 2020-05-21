package com.tao.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tao.blog.bean.Content;
import com.tao.blog.service.ContentService;
import com.tao.blog.pojo.BlogResult;
import com.tao.common.utils.AIResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 17:16
 **/
@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
   * 创建或修改完章
     **/
    @RequestMapping(value = "/createOrEditArticle", method = RequestMethod.POST,produces="application/json")
    @ResponseBody
    public AIResult saveUser(@RequestBody Content content) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        content.setCreateTime(dateString);
        try {
            if(content.getContentId()==null){
                contentService.save(content);

                Map<String,Object> map=new HashMap<>();
                BlogResult contents = contentService.getArticleById(content.getContentId());
                map.put("title",contents.getTitle());
                map.put("content",contents.getContent());
                map.put("id",contents.getContentId());
                map.put("userId",contents.getUserId());

                map.put("username",contents.getUsername());
                map.put("type",0);
                rabbitTemplate.convertAndSend("es.save.queue",map);
            }else{
                contentService.edit(content);
                BlogResult contents = contentService.getArticleById(content.getContentId());
                Map<String,Object> map=new HashMap<>();
                map.put("title",contents.getTitle());
                map.put("content",contents.getContent());
                map.put("id",contents.getContentId());
                map.put("userId",contents.getUserId());

                map.put("username",contents.getUsername());
                map.put("type",0);
                rabbitTemplate.convertAndSend("es.update.queue",map);
            }

        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("发布成功");
    }
    /**
     * 得到热门文章
     **/
    @RequestMapping(value = "/getHotArticle", method = RequestMethod.POST)
    @ResponseBody
    public AIResult getHotArticle(Integer page, Integer row,Integer  type) {
        try {
            PageInfo<BlogResult> contents = contentService.getHotArticle( page,  row,type);
            return AIResult.ok(contents);
        } catch (Exception e) {
            e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }
    }
    /**
     * 最新热门文章
     **/
    @RequestMapping(value = "/getLastArticle", method = RequestMethod.POST)
    @ResponseBody
    public AIResult getLastArticle(Integer page, Integer row ,Integer  type) {
        try {
            PageInfo<BlogResult> contents = contentService.getLastArticle(page,  row,type);
            return AIResult.ok(contents);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }
    /**
     * 根据用户id查询文章
     **/

    @RequestMapping(value = "/getArticleByUid", method = RequestMethod.POST)
    @ResponseBody
    public AIResult getArticleByUid(Integer userId, Integer status,Integer page, Integer row) {  //根据用户id查询不同状态的文章
        try {
            PageInfo<BlogResult> contents = contentService.getArticleByUid(userId, status ,page,  row);
            return AIResult.ok(contents);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }
    /**
     * 根据id查找文章
     **/
    @RequestMapping(value = "/getArticleById", method = RequestMethod.POST)
    @ResponseBody
    public AIResult getArticleById(Integer contentId,Integer userId) {
        try {

            BlogResult contents = contentService.getArticleById(contentId);

            return AIResult.ok(contents);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }
    /**
     * 删除文章
     **/
    @RequestMapping(value = "/deleteByCid")
    @ResponseBody
    public AIResult deleteArticle(Integer contentId,Integer userId) {

        try {
            BlogResult contents = contentService.getArticleById(contentId);
            contentService.deleteArticleByCid(contentId,userId);
            Map<String,Object> map=new HashMap<>();
            map.put("title",contents.getTitle());
            map.put("content",contents.getContent());
            map.put("id",contents.getContentId());
            map.put("userId",contents.getUserId());
            map.put("username",contents.getUsername());
            map.put("type",0);
            rabbitTemplate.convertAndSend("es.save.queue",map);
            return AIResult.ok("删除成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());
        }
    }



}
