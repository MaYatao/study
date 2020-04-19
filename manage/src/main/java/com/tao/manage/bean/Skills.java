package com.tao.manage.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_skill")
@Data
public class Skills {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer killId;
    private   Integer  did;
}
