package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.base.controller.BaseController;
import com.shawn.learningalways.base.model.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName: CaptchaController
 * @Description
 * @author: Shawn Wu
 * @date: 2019/5/17 17:03
 * @version:
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaController extends BaseController {

    /**
     * @Description 返回验证码页面
     *              访问路径为：http://localhost:5001/learningAlways/captcha/captchaHtml
     * @param
     * @return 
     * @date 2019/5/17 17:28
     * @auther Shawn Wu
     */
    @GetMapping("/captchaHtml")
    public String captchaHtml(){
        return "captcha/captcha";
    }

    /**
     * @Description 获取验证码
     * @param resp
     * @param session
     * @return 
     * @date 2019/5/17 17:10
     * @auther Shawn Wu
     */
    @RequestMapping("/drawcheckcode")
    @ResponseBody
    public void drawCheckCode(HttpServletResponse resp, HttpSession session) throws IOException {
        resp.setContentType("image/jpg");
        int width = 70;
        int height = 25;
        Captcha c = Captcha.getInstance();
        c.set(width, height);
        String checkcode = c.generateCheckcode();
        // 验证码放入session
        session.setAttribute("cCode", checkcode);
        OutputStream os = resp.getOutputStream();
        ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
    }

}