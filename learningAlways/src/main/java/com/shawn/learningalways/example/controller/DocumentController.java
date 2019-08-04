package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.base.controller.BaseController;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.example.model.Example;
import com.shawn.learningalways.example.service.impl.ExampleServiceImpl;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName: DocumentController
 * @Description 文件处理控制层
 * @author: Shawn Wu
 * @date: 2019/8/4 18:17
 * @version:
 */
@RestController
@RequestMapping("/document")
public class DocumentController extends BaseController {

    @Autowired
    ExampleServiceImpl exampleServiceImpl;


    /**
     * @Description 获取excel文件对象
     * @param sheetName sheet名
     * @param title 表头名
     * @param values 数据值
     * @param wb 文件对象
     * @return
     * @date 2019/8/4 19:01
     * @auther Shawn Wu
     */
    private HSSFWorkbook getHSSfWorkbook(String sheetName, String[]title, String[][]values, HSSFWorkbook wb){

        /*
         * 第一步：如果没传入，则创建一个HSSFWorkbook，对应一个excel文件
         */
        if(null == wb){
            wb = new HSSFWorkbook();
        }

        /*
         * 第二步：在workbook中添加一个sheet，对应excel文件中的sheet
         */
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 设置"创建时间"列的宽度
        sheet.setColumnWidth(3, 5000);

        /*
         * 第三步：在sheet中添加表头第0行。注意老版本poi对excel的行数列数有限制
         */
        HSSFRow row = sheet.createRow(0);

        /*
         * 第四步：创建单元格，并设置表头值和样式
         */
        HSSFCellStyle style = wb.createCellStyle();
        // 表头加粗显示
        Font font = wb.createFont();
        font.setBold(true);
        style.setFont(font);
        // 设置表头水平居中显示
        style.setAlignment(HorizontalAlignment.CENTER);
        // 声明列对象
        HSSFCell cell = null;
        // 设置表头内容和样式
        for(int i=0; i<title.length; i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        /*
         * 第五步：设置表格内容
         */
        for(int i=0; i<values.length; i++){
            // 创建新的一行
            row = sheet.createRow(i + 1);
            for(int j=0; j<values[i].length; j++){
                // 将内容按顺序赋值给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }


    /**
     * @Description 设置响应头
     * @param response
     * @param fileName
     * @return
     * @date 2019/8/4 19:09
     * @auther Shawn Wu
     */
    private void setResponseHeader(HttpServletResponse response, String fileName) {

        try {
            fileName = new String(fileName.getBytes(), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
    }


    @PostMapping(value = "/exportExcel")
    public JsonResult exportExcel(HttpServletResponse response, @RequestBody Example example){

        // 获取要导出的数据
        List<Example> exampleList = exampleServiceImpl.getExampleListByCondition(example);

        // 设置excel的表头
        String[] title = {"姓名", "年龄", "创建人", "创建时间"};
        // 设置excel的文件名
        String fileName = "示例excel导出"+System.currentTimeMillis()+".xls";
        // 设置excel的sheet名
        String sheetName = "示例sheet";

        // 内容数据
        String[][] content = new String[exampleList.size()][title.length];
        for(int row=0; row<exampleList.size(); row++){
            content[row][0] = exampleList.get(row).getName();
            content[row][1] = String.valueOf(exampleList.get(row).getAge());
            content[row][2] = exampleList.get(row).getCreater();
            content[row][3] = exampleList.get(row).getCreateTime();
        }

        // 获取Excel文件对象
        HSSFWorkbook wb = getHSSfWorkbook(sheetName, title, content, null);

        // 输出excel
        setResponseHeader(response, fileName);
        try {
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return renderSuccess();
    }
}