package com.tao.manage.es;

import com.tao.course.bean.Couerses;
import com.tao.manage.pojo.SearchParam;
import org.apache.catalina.core.StandardService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsCourseService implements StandardService, InitializingBean {

    @Autowired
    private ElasticOperationService elasticOperationService;
    
    private String index = "course-api";
    
    private String type = "Couerses";
    
    
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
    public void addUser(Couerses couerses) {
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
	   param.setUserName(title);
	   return elasticOperationService.queryDocumentByParam(index, type, param,Couerses.class);
    }


    @Override
    public List<Couerses> queryByRoleName(Couerses couerses) {
	   SearchParam param = new SearchParam();
	 //  param.setRoleName(role.getName());
	   return elasticOperationService.queryDocumentByParam(index, type, param,Couerses.class);
    }

}