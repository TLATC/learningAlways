package com.shawn.learningalways.base.util;

import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

/**
 * @ClassName: XmlJsonUtils
 * @Description xml和Json互转工具类
 * @author: Shawn Wu
 * @date: 2020/1/4 16:17
 * @version:
 */
public class XmlJsonUtils {

    /**
     * @Description xml转化为Json
     * @param xmlString xml格式字符串
     * @return result json格式字符串
     * @date 2020/1/4 16:19
     * @auther Shawn Wu
     */
    public static String xmlToJson(String xmlString){
        //创建 XMLSerializer对象
        XMLSerializer xmlSerializer = new XMLSerializer();
        //将xml转为json（注：如果是元素的属性，会在json里的key前加一个@标识）
        String result = xmlSerializer.read(xmlString).toString();
        return result;
    }


    /**
     * @Description json转化为xml字符串
     * @param jsonString json字符串
     * @return 
     * @date 2020/1/4 16:28
     * @auther Shawn Wu
     */
    public static String jsonToXml(String jsonString){
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setTypeHintsEnabled(false);
        String xml = xmlSerializer.write(JSONSerializer.toJSON(jsonString));
        xml = xml.replace("<o>", "").replace("</o>", "");
        xml = xml.replaceAll("\r\n", "").concat("\r\n");
        return xml;
    }


    public static void main(String[] args) {

        String xmlString = "<service>\n" +
                "  <sys_head>\n" +
                "    <aaa>111</aaa>\n" +
                "    <array>\n" +
                "      <ret>\n" +
                "         <arr1>数组1.1</arr1>\n" +
                "         <arr2>数组1.2</arr2>\n" +
                "      </ret>\n" +
                "      <ret>\n" +
                "         <arr1>数组2.1</arr1>\n" +
                "         <arr2>数组2.2</arr2>\n" +
                "      </ret>\n" +
                "    </array>\n" +
                "    <bbb>222</bbb>\n" +
                "  </sys_head>\n" +
                "  <app_head>\n" +
                "    <ccc>333</ccc>\n" +
                "    <ddd>444</ddd>\n" +
                "    <eee>555</eee>\n" +
                "  </app_head>\n" +
                "</service>";
        String jsonResult = xmlToJson(xmlString);
        //输出json内容
        System.out.println("转化后的json数据为：" + jsonResult);



        String jsonString = "{\"sys_head\":{\"aaa\":\"111\",\"array\":[{\"arr1\":\"数组1.1\",\"arr2\":\"数组1.2\"},{\"arr1\":\"数组2.1\",\"arr2\":\"数组2.2\"}],\"bbb\":\"222\"},\"app_head\":{\"ccc\":\"333\",\"ddd\":\"444\",\"eee\":\"555\"}}";
        String xmlResult = jsonToXml(jsonString);
        System.out.println("转化后的xml数据为：" + xmlResult);
    }
}