package com.tao.manage.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_direction")
@Data
public class Direction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   int directionId;
    private  String  direction;
    private  String  skillId;
}
