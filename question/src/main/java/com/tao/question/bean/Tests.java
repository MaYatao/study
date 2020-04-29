package com.tao.question.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description 试卷
 * @date 2019/10/29 18:37
 **/
@Entity
@Table(name = "tb_test")
@Data
public class Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testId;
    /**
     * 测试名
     */
    private String title;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;
    /**
     * 总分数
     */
    @Column(name = "blank_score")
    private int blankScore;
    /**
     * 作者
     */
    @Column(name = "user_id")
    private int userId;
    /**
     * 得分
     */
    @Column(name = "socre", columnDefinition = "int default 0")
    private int socre;

    /**
     *
     */
    @Column(name = "choice_questios")
    private String choiceQuestios;
    /**
     *
     */
    @Column(name = "choices_questios")
    private String choicesQuestios;
    /**
     * 试题数
     */
    @Column(name = "count", columnDefinition = "int default 0")
    private int count;
    /**
     * 0 表示专项训练，1表示习题
     */
    @Column(name = "type", columnDefinition = "int default 0")
    private int type;
    /**
     * 试题难度
     */
    @Column(name = "status", columnDefinition = "int default 0")
    private int status;
    /**
     * 备注
     */
    private String other;
    @Column(name = "views", columnDefinition = "int default 0")
    private int views;
}
