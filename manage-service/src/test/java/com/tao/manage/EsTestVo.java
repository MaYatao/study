package com.tao.manage;

import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/26 9:43
 */

@Data
public class EsTestVo {
    private  Long  id;
    private  String  name;
    private  int  age;
    private  String info;


    public EsTestVo() {
    }

    public EsTestVo(Long id, String name, int age, String info) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.info = info;
    }

    public EsTestVo(Long id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }
}
