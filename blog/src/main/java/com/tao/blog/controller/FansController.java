package com.tao.blog.controller;

import com.tao.blog.service.FansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 17:15
 **/

@Controller
public class FansController {

   @Autowired
    private   FansService  fansService;

   @ResponseBody
   @GetMapping("/")
   public List get(){
       return  fansService.get();
   }
}
