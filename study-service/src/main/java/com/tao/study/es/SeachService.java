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



    public void add(SearchParam user) {
	   elasticOperationService.addDocument(index, type, user);
    }


    public void deleted (SearchParam param){
    	elasticOperationService.deleteDocumentByQuery(index, type,param);
    }


    public void update(SearchParam param) {

	   elasticOperationService.updateDocumentByQuery(index, type,param,param);
    }

      public List<SearchParam> queryByName(String title) {
        SearchParam param = new SearchParam();
	    param.setTitle(title);
	   return elasticOperationService.queryDocumentByParam(index, type, param,SearchParam.class);
    }

}
