package com.tao.manage.pojo;

import java.util.Date;

public class Role {
    
    
    private String id;
    
    
    private String name;
    
    
    private Date createTime;
    
    
    private String description;
    
    public Role() {}
    
    public Role(String name,String description,Date createTime) {
	this.name = name;
	this.description = description;
	this.createTime = createTime;
    }
    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public Date getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }
    
}