package com.shawn.eurekaconsumer.service;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


/**
 * @ClassName: FeignUploadService
 * @Description 使用Feign进行文件上传
 * @author: Shawn Wu
 * @date: 2019/10/7 10:19
 * @version:
 */
@FeignClient(value = "upload-server", configuration = FeignUploadService.MultipartSupportConfig.class)
public interface FeignUploadService {

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }

    /**
     * @Description 文件上传
     * @param file
     * @return
     * @date 2019/10/7 10:34
     * @auther Shawn Wu
     */
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value="file")MultipartFile file);
}
