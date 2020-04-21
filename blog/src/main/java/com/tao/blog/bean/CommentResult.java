package com.tao.blog.bean;

import lombok.Data;

import java.util.List;

@Data
public class CommentResult {
    private  String fusername;
    private  int fuserId;
    private   String  fheadImage;  //头像
    private  String tusername;
    private  int tuserId;
    private  String theadImage;  //头像
    private Integer contentId;
    private Integer courseId;
    private  Comment comment;
    private Integer parentId;
    private List<CommentResult>  commentResults;
}
