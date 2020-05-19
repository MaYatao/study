package com.tao.study.es;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeachService {

    @Autowired
    private ElasticOperationService elasticOperationService;

    private String index = "seach-api";

    private String type = "user";

    public void afterPropertiesSet() throws Exception {
	   elasticOperationService.createIndexIfNotExist(index, type);
    }

    public void batchAddBean(List<SearchParam> bean) {
	   if(CollectionUtils.isEmpty(bean)) {
	       return ;
	   }
	   for(SearchParam user :bean) {
	       elasticOperationService.addDocumentToBulkProcessor(index, type, user);
	   }
    }



    public void addUser(SearchParam user) {
	   elasticOperationService.addDocument(index, type, user);
    }


    public void deletedUserById(String id) {
    	elasticOperationService.deleteDocumentById(index, type, id);
    }


    public void updateUser(SearchParam user) {
	   String id = user.getId();
	   user.setId(null);
	   elasticOperationService.updateDocument(index, type,id, user);
    }

      public List<SearchParam> queryByUserName(String title) {
        SearchParam param = new SearchParam();
	   param.setTitle(title);
	   return elasticOperationService.queryDocumentByParam(index, type, param,SearchParam.class);
    }

}
