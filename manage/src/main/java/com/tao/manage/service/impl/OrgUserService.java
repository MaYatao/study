package com.tao.manage.service.impl;


import com.tao.manage.mapper.ElasticOperationService;
import com.tao.manage.pojo.Role;
import com.tao.manage.pojo.User;
import com.tao.manage.pojo.UserSearchParam;
import org.apache.catalina.core.StandardService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgUserService extends StandardService implements InitializingBean {

    @Autowired
    private ElasticOperationService elasticOperationService;
    
    private String index = "test-api";
    
    private String type = "user";
    
    

    public void afterPropertiesSet() throws Exception {
	   elasticOperationService.createIndexIfNotExist(index, type);
    }
    
    
    public void batchAddUser(List<User> users) {
	   if(CollectionUtils.isEmpty(users)) {
	       return ;
	   }
	   for(User user :users) {
	       elasticOperationService.addDocumentToBulkProcessor(index, type, user);
	   }
    }
    
    

    public void addUser(User user) {
	   elasticOperationService.addDocument(index, type, user);
    }


    public void deletedUserById(String id) {
    	elasticOperationService.deleteDocumentById(index, type, id);
    }


    public void updateUser(User user) {
	   String id = user.getId();
	   user.setId(null);
	   elasticOperationService.updateDocument(index, type,id, user);
    }


    public List<User> queryByUserName(String userName) {
	
	   UserSearchParam param = new UserSearchParam();
	   param.setUserName(userName);
	   return elasticOperationService.queryDocumentByParam(index, type, param,User.class);
    }



    public List<User> queryByRoleName(Role role) {
	   UserSearchParam param = new UserSearchParam();
	   param.setRoleName(role.getName());
	   return elasticOperationService.queryDocumentByParam(index, type, param,User.class);
    }

}