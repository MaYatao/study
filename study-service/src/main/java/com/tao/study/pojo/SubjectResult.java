package com.tao.study.pojo;

import lombok.Data;

import java.util.List;

@Data
public class SubjectResult {

    private  int value;
    private  String label;
    private List<SubjectResult> children;

}
