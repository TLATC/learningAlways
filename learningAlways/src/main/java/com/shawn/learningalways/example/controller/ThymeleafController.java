package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.base.controller.BaseRender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统名称: mySpringBoot
 * 模块名称:
 * 类 名 称: ThymeleafController
 * 软件版权: Shawn Wu
 * 功能说明：
 * 系统版本：v1.0.1
 * 开发人员: Shawn Wu
 * 开发时间: 2019/4/10 20:24
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Controller
public class ThymeleafController extends BaseRender {

    /**
     * @Description 返回index.html
     * @param
     * @return
     * @date 2019/4/10 20:26
     * @author Shawn Wu
     */
    @RequestMapping("/index")
    public String index(ModelMap map){
        // 加入一个属性，模板中可以读取该属性
        map.addAttribute("thymelaf", "这是一个通过Thymeleaf渲染的页面");
        // 返回的模板文件的名称，此处是src/main/resources/templates/index.html
        return "index";
    }

}
