package com.shawn.eurekaconsumer;

import com.shawn.eurekaconsumer.service.FeignUploadService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.io.*;

/**
 * @ClassName: FeginUploadTester
 * @Description 文件上传测试
 * @author: Shawn Wu
 * @date: 2019/10/7 10:36
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FeginUploadTester {

    @Autowired
    private FeignUploadService feignUploadService;

    Logger logger;

    @Test
    public void testHandleFileUpload(){
        File file = new File("upload.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()){
            IOUtils.copy(input, os);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid File：" + e, e);
        }

        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        logger.info(feignUploadService.handleFileUpload(multipartFile));
    }
}