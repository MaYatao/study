package com.tao.question.mapper;


import com.tao.question.bean.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:52
 **/
@org.apache.ibatis.annotations.Mapper
public interface QuestionsMapper extends Mapper<Question> {
    @Select("<script> SELECT * " +
            " FROM tb_question" +
            " WHERE   subject in " +
            "<foreach item='id' index='index' collection='subjects' open='(' close=')' separator=',' > #{id ,jdbcType=INTEGER}  </foreach>" +
            " and type in " +
            "<foreach item='type' index='index' collection='types' open='(' close=')' separator=','> #{type,jdbcType=INTEGER} </foreach>" +
            " <if test='degree != 0 ' >  and  degree = #{degree} </if>  ORDER BY RAND()  LIMIT #{num} </script>")
    public List<Question> slectQuestionBySubject(@Param("subjects") List<Integer> subjects, @Param("types") List<Integer> types, @Param("degree") int degree, @Param("num") int num);

}
