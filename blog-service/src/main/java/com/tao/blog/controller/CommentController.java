package com.tao.blog.controller;

import com.tao.blog.bean.Comment;
import com.tao.blog.pojo.CommentResult;
import com.tao.blog.service.CommentService;
import com.tao.common.utils.AIResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 17:16
 **/
@Controller
public class CommentController {

    @Autowired
    private CommentService  commentService;
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    @ResponseBody
    public AIResult createComment( Comment comment) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String dateString = formatter.format(currentTime);
        comment.setCommentTime(dateString);

       try {
            commentService.save(comment);
            Map<String,Object> map=new HashMap<>();

           map.put("fromUser",comment.getFromUser())   ;//点赞转发者
           map.put("toUser",comment.getToUser());
           map.put("sentTime",comment.getCommentTime());
           map.put("title","对你进行了的评论");
           map.put("contentId",comment.getContentId());
           map.put("courseId",comment.getCourseId());
           map.put("type",1);
           rabbitTemplate.convertAndSend("matao.comment.queue",map);
           return AIResult.ok("发布成功");
        } catch (Exception e) {
         e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/getCommentByContentId", method = RequestMethod.POST)
    @ResponseBody
    public AIResult getCommentByContentId(Integer contentId) {  //根据用户id查询不同状态的文章

   try {
            List<CommentResult> commentResults= commentService.getCommentByCId(contentId);
            return AIResult.ok(commentResults);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/getCommentByCourseId", method = RequestMethod.POST)
    @ResponseBody
    public AIResult getCommentByCourseId(Integer courseId) {  //根据用户id查询不同状态的文章

        try {
            List<CommentResult> commentResults= commentService.getCommentByCourseId(courseId);
            return AIResult.ok(commentResults);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());
        }
    }



    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    @ResponseBody
    public AIResult deleteComment(Integer commentId) {
        try {
            commentService.deleteComment(commentId);
            return AIResult.ok("删除成功");
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());

        }
    }

}
