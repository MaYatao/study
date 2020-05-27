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


    private Integer  sid; //资源id

    private String  title;
    // 内容
    private Integer  userId;

    private String createTime;
    private  String username;
    private Integer type;     //0 帖子  1课程  3 试题
    private String  imageUrl; // 封面

}
