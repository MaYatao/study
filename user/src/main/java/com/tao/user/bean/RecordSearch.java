package com.tao.user.bean;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_record_search")
@Data
public class RecordSearch {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer  rsid;
}
