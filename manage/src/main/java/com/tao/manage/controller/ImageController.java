package com.tao.manage.controller;


import com.github.pagehelper.PageInfo;
import com.tao.common.utils.AIResult;
import com.tao.manage.bean.Image;
import com.tao.manage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:24
 **/
@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/createImage", method = RequestMethod.POST,produces="application/json")
    public AIResult createImage(@RequestBody Image iamge) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        iamge.setPublishTime(dateString);
        try {
            imageService.save(iamge);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("发布成功");
    }
    @RequestMapping(value = "/getImage")
    public AIResult getImage(Integer page, Integer row) {
        try {
            PageInfo<Image> imagePageInfo = imageService.getImage( page,  row);
            return AIResult.ok(imagePageInfo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping("/deleteImageById")
    public AIResult deleteImageById(Integer imageId) {
        imageService.deleteImageById(imageId);
        return AIResult.ok("删除成功");
    }


}
