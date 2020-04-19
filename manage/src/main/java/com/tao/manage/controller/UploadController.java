package com.tao.manage.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.tao.common.utils.AIResult;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    public AIResult uploadFile(MultipartFile file) {
        try {
         /*   Set<MataData> mataData = new HashSet<>();
            if (file.getName() != null) {

                mataData.add(new MataData("name", file.getName()));
            }*/// 上传   （文件上传可不填文件信息，填入null即可）
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);


            String url = "http://192.168.183.130/" + storePath.getFullPath();
            return AIResult.ok(url);
        } catch (Exception e) {
            e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }
    }
}
