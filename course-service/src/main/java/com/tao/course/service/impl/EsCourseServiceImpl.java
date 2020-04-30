package com.tao.course.service.impl;

import com.tao.study.es.SearchParam;
import com.tao.course.bean.Couerses;
import com.tao.study.es.ElasticOperationService;

import com.tao.course.service.EsCourseService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsCourseServiceImpl implements EsCourseService, InitializingBean {

    @Autowired
    private ElasticOperationService elasticOperationService;
    
    private String index = "course-api";
    
    private String type = "couerses";
    
    
    @Override
    public void afterPropertiesSet() throws Exception {
	   elasticOperationService.createIndexIfNotExist(index, type);
    }
    
    
    public void batchAddCourse(List<Couerses> couersesList) {
	   if(CollectionUtils.isEmpty(couersesList)) {
	       return ;
	   }
	   for( Couerses couerses :couersesList) {
	       elasticOperationService.addDocumentToBulkProcessor(index, type, couerses);
	   }
    }



    @Override
    public void addCouerses(Couerses couerses) {
	   elasticOperationService.addDocument(index, type, couerses);
    }

    @Override
    public void deletedCouersesById(String id) {
    	elasticOperationService.deleteDocumentById(index, type, id);
    }

    @Override
    public void updateCouerses(Couerses couerses) {
	   Integer id = couerses.getCourseId();
        couerses.setCourseId(null);
	   elasticOperationService.updateDocument(index, type,String.valueOf(id) , couerses);
    }

    @Override
    public List<Couerses> queryByTitle(String title) {
	   SearchParam param = new SearchParam();
	   param.setTitle(title);
	   return elasticOperationService.queryDocumentByParam(index, type, param,Couerses.class);
    }


}