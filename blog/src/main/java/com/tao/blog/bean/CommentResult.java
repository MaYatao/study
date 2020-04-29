package com.tao.blog.bean;

import lombok.Data;

import java.util.List;

@Data
public class CommentResult {
    private String fusername;
    private int fuserId;

    private String fheadImage;
    private String tusername;
    private int tuserId;
    private String theadImage;
    private Integer contentId;
    private Integer courseId;
    private Comment comment;
    private Integer parentId;
    private List<CommentResult> commentResults;
}
