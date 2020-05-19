package com.tao.study.es;

import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/26 10:01
 */
@Data
public class SearchParam {

    private String id;
    // 课程描述
    private String description;
    //学习基础
    private String basics;

   /* private String createTime;*/
    //学习目标
    private String goal;
    //标题
    private String title;
  // 内容
    private String content;
    private Integer type;  //0 帖子  1课程  3 试题

}
