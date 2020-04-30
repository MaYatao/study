package com.tao.blog.service;

import com.tao.blog.bean.Comment;
import com.tao.blog.pojo.CommentResult;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 17:18
 **/
public interface CommentService {

   public  void save(Comment comment);

    List<CommentResult> getCommentByCId(Integer contentId);

    void deleteComment(Integer commentId);

    List<CommentResult> getCommentByCourseId(Integer courseId);
}
