package com.tao.blog.service.impl;

import com.tao.blog.bean.Content;
import com.tao.blog.service.EsBlogService;
import com.tao.common.es.ElasticOperationService;
import com.tao.common.es.SearchParam;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsContentServiceImpl implements EsBlogService, InitializingBean {

    @Autowired
    private ElasticOperationService elasticOperationService;
    
    private String index = "blog-api";
    
    private String type = "blog";
    
    
    @Override
    public void afterPropertiesSet() throws Exception {
	   elasticOperationService.createIndexIfNotExist(index, type);
    }
    
    
    public void batchAddCourse(List<Content> contentList) {
	   if(CollectionUtils.isEmpty(contentList)) {
	       return ;
	   }
	   for( Content content :contentList) {
	       elasticOperationService.addDocumentToBulkProcessor(index, type, content);
	   }
    }



    @Override
    public void addContent(Content content) {

        elasticOperationService.addDocument(index, type, content);
    }

    @Override
    public void deletedContentById(String id) {
    	elasticOperationService.deleteDocumentById(index, type, id);
    }

    @Override
    public void updateContent(Content content) {
	   Integer id = content.getContentId();
        content.setContentId(null);
	   elasticOperationService.updateDocument(index, type,String.valueOf(id) , content);
    }

    @Override
    public List<Content> queryByTitle(String title) {
	   SearchParam param = new SearchParam();
	   param.setTitle(title);
	   return elasticOperationService.queryDocumentByParam(index, type, param,Content.class);
    }


}