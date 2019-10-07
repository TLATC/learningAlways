package com.shawn.eurekaclient;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: UploadController
 * @Description 文件上传
 * @author: Shawn Wu
 * @date: 2019/10/7 10:11
 * @version:
 */
@RestController
public class UploadController {

    /**
     * @Description 文件上传
     * @param file 文件对象
     * @return 文件名
     * @date 2019/10/7 10:14
     * @auther Shawn Wu
     */
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file){
        // 省略真正的上传。。。
        return file.getName();
    }
}