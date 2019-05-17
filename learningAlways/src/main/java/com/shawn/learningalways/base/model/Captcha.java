package com.shawn.learningalways.base.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @ClassName: Captcha
 * @Description 验证码实体类
 * @author: Shawn Wu
 * @date: 2019/5/17 10:02
 * @version:
 */
public class Captcha {

    /**
     * 验证码图片宽度
     */
    private int width;
    /**
     * 验证码图片高度
     */
    private int height;
    /**
     * 验证码位数（默认4位）
     */
    private int num = 4;
    /**
     * 验证码（由数字和字母组成，不区分大小写）
     */
    private String code;

    /**
     * 随机数
     */
    private static final Random ran = new Random();

    /**
     * 单例模式
     */
    private static Captcha captcha;

    private Captcha(){
        code = "01abcde23fghi45jkmnpqrstu67vwxyz89";
    }

    public static Captcha getInstance(){
        if(captcha==null){
            captcha = new Captcha();
        }
        return captcha;
    }

    public void set(int width, int height, int num, String code){
        this.width = width;
        this.height = height;
        this.setNum(num);
        this.setCode(code);
    }

    public void set(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @Description 生成验证码
     * @param
     * @return 
     * @date 2019/5/17 11:20
     * @auther Shawn Wu
     */
    public String generateCheckcode() {
        StringBuffer cc = new StringBuffer();
        for(int i=0;i<num;i++) {
            cc.append(code.charAt(ran.nextInt(code.length())));
        }
        return cc.toString();
    }

    /**
     * @Description 生成验证码图片
     * @param checkCode 验证码
     * @return 
     * @date 2019/5/17 11:58
     * @auther Shawn Wu
     */
    public BufferedImage generateCheckImg(String checkCode){
        // 创建一个图片对象
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图片对象的画笔
        Graphics2D graphics2D = img.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawRect(0, 0, width-1, height-1);
        // 设置字体（宋体，加粗，倾斜）
        Font font = new Font("宋体", Font.BOLD + Font.ITALIC, (int)(height * 0.8));
        graphics2D.setFont(font);
        // 设置验证码字体颜色，划线
        for(int i=0; i<num; i++){
            graphics2D.setColor(new Color(ran.nextInt(180), ran.nextInt(180), ran.nextInt(180)));
            graphics2D.drawString(String.valueOf(checkCode.charAt(i)), i*(width/num)+4, (int)(height*0.8));
        }

        // 加一些干扰点
        for(int i=0; i<(width+height); i++){
            graphics2D.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
            graphics2D.drawOval(ran.nextInt(width), ran.nextInt(height), 1, 1);
        }

        // 加一些干扰线
        for(int i=0; i<4; i++){
            graphics2D.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
            graphics2D.drawLine(0, ran.nextInt(height), width, ran.nextInt(height));
        }

        return img;
    }

    
}