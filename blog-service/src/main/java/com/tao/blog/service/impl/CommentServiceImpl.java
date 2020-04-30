package com.tao.blog.service.impl;


import com.tao.blog.bean.Comment;
import com.tao.blog.pojo.CommentResult;
import com.tao.blog.bean.RecordHistory;
import com.tao.blog.mapper.CommentMapper;
import com.tao.blog.mapper.ContentMapper;
import com.tao.blog.mapper.RecordHistoryMapper;
import com.tao.blog.service.CommentService;
import com.tao.user.bean.User;
import com.tao.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 17:29
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordHistoryMapper recordHistoryMapper;

    @Override
    public void save(Comment comment) {
        RecordHistory recordHistory = new RecordHistory();
        recordHistory.setFromUser(comment.getFromUser());
        if (comment.getToUser() != null) {
            recordHistory.setToUser(comment.getToUser());
        }
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        recordHistory.setCommentTime(dateString);
        if(comment.getContentId()!=null) {
            recordHistory.setContentId(comment.getContentId());
        }
        recordHistoryMapper.insert(recordHistory);
        commentMapper.insert(comment);
    }



    @Override
    public List<CommentResult> getCommentByCId(Integer contentId) {
        Example example = new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIsNull("parentId");
        criteria.andEqualTo("contentId",contentId);
        List<CommentResult> commentResults = new ArrayList<>();
        List<Comment> commentList = commentMapper.selectByExample(example);
        for (Comment comment : commentList) {
            commentResults.add(getCommentResult(comment));
        }
        return commentResults;
    }

    private CommentResult getCommentResult(Comment c) {
        CommentResult commentResult = new CommentResult();
        commentResult.setComment(c);
        commentResult.setContentId(c.getContentId());

        User fu = userMapper.selectByPrimaryKey(c.getFromUser());
        commentResult.setFuserId(fu.getUserId());
        commentResult.setFheadImage(fu.getHeadImage());
        commentResult.setFusername(fu.getUsername());

        if (c.getToUser() != null) {
            User tu = userMapper.selectByPrimaryKey(c.getToUser());
            commentResult.setTuserId(tu.getUserId());
            commentResult.setTheadImage(tu.getHeadImage());
            commentResult.setTusername(tu.getUsername());
        }


        Example example = new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", c.getCommentId());
        example.orderBy("commentTime");
        List<Comment> commentList = commentMapper.selectByExample(example);
        ArrayList<CommentResult> commentResults = new ArrayList<>();
        commentResult.setCommentResults(commentResults);
        for (Comment comment : commentList) {
            CommentResult commentResult1 = new CommentResult();
            commentResult1.setComment(comment);
            commentResult1.setContentId(comment.getContentId());
            User fu1 = userMapper.selectByPrimaryKey(comment.getFromUser());
            commentResult1.setFuserId(fu1.getUserId());
            commentResult1.setFheadImage(fu1.getHeadImage());
            commentResult1.setFusername(fu1.getUsername());
            commentResult1.setParentId(c.getCommentId());
            User tu = userMapper.selectByPrimaryKey(comment.getToUser());
            if(tu!=null) {
                commentResult1.setTuserId(tu.getUserId());
                commentResult1.setTheadImage(tu.getHeadImage());
                commentResult1.setTusername(tu.getUsername());
            }
            commentResult.getCommentResults().add(commentResult1);
        }

        return commentResult;
    }


    @Override
    public void deleteComment(Integer commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public List<CommentResult> getCommentByCourseId(Integer courseId) {
        Example example = new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIsNull("parentId");
        criteria.andEqualTo("courseId",courseId);
        List<CommentResult> commentResults = new ArrayList<>();
        List<Comment> commentList = commentMapper.selectByExample(example);
        for (Comment comment : commentList) {
            commentResults.add(getCommentResult(comment));
        }
        return commentResults;
    }
}
