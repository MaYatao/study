package com.tao.study.pojo;

import lombok.Data;

import java.util.List;

@Data
public class KnoledgeResult {

    private  int value;
    private  String label;
    private List<KnoledgeResult> children;
}
