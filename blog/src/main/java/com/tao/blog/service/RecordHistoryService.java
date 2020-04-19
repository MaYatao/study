package com.tao.blog.service;

import com.tao.blog.bean.RecordHistory;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/7 16:52
 **/
public interface RecordHistoryService {
  public   void addViews(RecordHistory recordHistory);

  public  void addCollection(RecordHistory recordHistory);
  public  void addAggre(RecordHistory recordHistory);
  public  void addComment(RecordHistory recordHistory);
}
