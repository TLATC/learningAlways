package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.base.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName: FileOptController
 * @Description 文件操作
 * @author: Shawn Wu
 * @date: 2019/5/8 9:41
 * @version:
 */
@Controller
@RequestMapping("/fileOpt")
public class FileOptController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(FileOptController.class);

    /**
     * 文件保存路径
     */
    private String uploadDir = "uploadDir";

    /**
     * @Description 访问upload.html，文件上传页面
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
     * @Description 文件上传
     *              第一阶段：上传到本地windows环境目录下
     * @param file 文件
     * @param map
     * @return
     * @date 2019/5/8 14:32
     * @auther Shawn Wu
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file, ModelMap map, HttpServletRequest request){
        // 加入一个属性，模板中可以读取该属性。默认上传失败
        map.addAttribute("result", "文件上传失败");

        if(file.isEmpty()){
            map.addAttribute("result", "文件为空");
            return "fileopt/upload";
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        // 临时文件目录
        String filePath = request.getSession().getServletContext().getRealPath("")+ "/" + uploadDir;
        LOGGER.debug("上传文件的临时目录是：", filePath);

        File dest = new File(filePath + "/" + fileName);
        // 如果父目录不存在，则创建
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            // 保存文件
            file.transferTo(dest);
            map.addAttribute("result", "文件上传成功");
            return "fileopt/upload";
        } catch (IOException e) {
            e.printStackTrace();
            map.addAttribute("result", "文件上传失败");
            return "fileopt/upload";
        }
    }

}