package com.tao.question.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description 试题
 * @date 2019/10/29 18:51
 **/
@Entity
@Table(name="tb_question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  qid;
    private   String  options;
       /**
     *问题难度
     */
    @Column(name="degree" ,columnDefinition="int default 0")
    private   Integer    degree;    
       /**
     *试题内容
     */
    private   String  content;  
       /**
     *试题类型  0 单选  1多选题
     */
    private   Integer   type;    
       /**
     * 答案
     */
    private   String  answer;     
       /**
     * 知识点
     */
    private   String    knowledge ;
    /**
     * 分值
     */
    @Column(name="score" ,columnDefinition="int default 0")
    private   int    score;        
    @Column(name="uid" ,columnDefinition="int default 0")
       /**
     *作者
     */ 
    private   Integer    uid;   
       /**
     *方向  前端，后端
     */
    @Column(name="direction")
    private   Integer     direction;  
       /**
     * 科目
     */
    @Column(name="subject")
    private   Integer     subject; 
       /**
     * 解析
     */
    private  String  analysis;   
       /**
     * 创建时间
     */
    @Column(name="create_time")
    private String    createTime;

}
