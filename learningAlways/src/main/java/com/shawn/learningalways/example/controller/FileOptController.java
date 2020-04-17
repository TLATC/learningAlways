package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.base.controller.BaseRender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: FileOptController
 * @Description 文件操作
 * @author: Shawn Wu
 * @date: 2019/5/8 9:41
 * @version:
 */
@Controller
@RequestMapping("/fileOpt")
public class FileOptController extends BaseRender {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileOptController.class);

    /**
     * 文件保存路径
     */
    private String uploadDir = "uploadDir";
    /**
     * 单文件上传本地项目服务器结果显示内容
     */
    private String singleLocalServerUploadResult = "singleLocalServerUploadResult";
    /**
     * 多文件上传本地项目服务器结果显示内容
     */
    private String mulLocalServerUploadResult = "mulLocalServerUploadResult";
    /**
     * 上传文件服务器结果显示内容
     */
    private String fileServerUploadResult = "fileServerUploadResult";


    /**
     * @Description 访问upload.html，文件上传页面
     *              路径为：http://localhost:5001/learningAlways/fileOpt/upload
     * @param
     * @return
     * @date 2019/5/8 9:48
     * @auther Shawn Wu
     */
    @GetMapping("/upload")
    public String upload(){
        return "fileopt/upload";
    }

    /**
     * @Description 单文件上传到本地服务器
     * @param file
     * @param map
     * @param request
     * @return
     * @date 2019/5/22 11:23
     * @auther Shawn Wu
     */
    @PostMapping("/uploadSingleToLocalServer")
    public String uploadSingleToLocalServer(@RequestParam("file")MultipartFile file, ModelMap map, HttpServletRequest request){
        // 加入一个属性，模板中可以读取该属性。默认上传失败
        map.addAttribute("result", "文件上传失败");

        if(file.isEmpty()){
            map.addAttribute("result", "文件为空");
            return "fileopt/upload";
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        // 临时文件目录
//        String filePath = request.getSession().getServletContext().getRealPath("")+ "/" + uploadDir;
        String filePath = request.getSession().getServletContext().getRealPath("");
        LOGGER.debug("上传文件的临时目录是：{}", filePath);

        File dest = new File(filePath + "/" + fileName);
        // 如果父目录不存在，则创建
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            // 保存文件
            file.transferTo(dest);
            map.addAttribute(singleLocalServerUploadResult, "单文件上传成功");
            return "fileopt/upload";
        } catch (IOException e) {
            LOGGER.error("单文件上传失败：", e);
            map.addAttribute(singleLocalServerUploadResult, "单文件上传失败");
            return "fileopt/upload";
        }
    }

    /**
     * @Description 多文件上传到本地服务器
     * @param map
     * @param request
     * @return 
     * @date 2019/5/22 13:54
     * @auther Shawn Wu
     */
    @PostMapping("/uploadMulToLocalServer")
    public String uploadMulToLocalServer(ModelMap map, HttpServletRequest request){

        // 加入一个属性，模板中可以读取该属性。默认上传失败
        map.addAttribute("result", "多文件上传失败");
        // 获取上传的文件
        List<MultipartFile> multipartFileList = ((MultipartHttpServletRequest)request).getFiles("fileNames");
        // 临时文件目录
        //        String filePath = request.getSession().getServletContext().getRealPath("")+ "/" + uploadDir;
        String filePath = request.getSession().getServletContext().getRealPath("");
        LOGGER.debug("上传文件的临时目录是：{}", filePath);

        // 空文件个数
        int emptyFileCount = 0;
        for(MultipartFile file:multipartFileList){
            if(file.isEmpty()){
                emptyFileCount++;
                continue;
            }

            // 文件名
            String fileName = file.getOriginalFilename();
            // 生成文件
            File dest = new File(filePath + "/" + fileName);
            // 如果父目录不存在，则创建
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdir();
            }

            try {
                // 保存文件
                file.transferTo(dest);
            } catch (IOException e) {
                LOGGER.error("多文件上传失败：", e);
                map.addAttribute(mulLocalServerUploadResult, "多文件上传失败");
                return "fileopt/upload";
            }
        }

        if(emptyFileCount == multipartFileList.size()){
            map.addAttribute(mulLocalServerUploadResult, "文件为空");
            return "fileopt/upload";
        }

        map.addAttribute(mulLocalServerUploadResult, "多文件上传成功");
        return "fileopt/upload";
    }

    // todo:上传到文件服务器


    // todo: 文件浏览，文件下载  参考：https://www.cnblogs.com/studyDetail/p/7003253.html

}