package com.iexport.servlet;

import org.apache.poi.ss.usermodel.Workbook;

import com.iexport.service.ExcelService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportExcelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExcelService service = new ExcelService();
        Workbook workbook = service.export(true);
        resp.setHeader("Content-Disposition","attachment;filename=export.xlsx");
        ServletOutputStream outputStream = resp.getOutputStream();


        // 直接将文件输出提供下载导�?
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        workbook.close();

        // 把文件先存下来再提供下载导出
        // 想用这种方法把上边�?�直接将文件输出提供下载导出】部分注释掉，把下边这部分代码放�?运行

//        FileOutputStream fileOutputStream = new FileOutputStream("d:/upload/export.xlsx");
//        workbook.write(fileOutputStream);
//        FileInputStream fileInputStream = new FileInputStream("d:/upload/export.xlsx");
//        byte[] bytes = new byte[fileInputStream.available()];
//        fileInputStream.read(bytes);
//        outputStream.write(bytes);
//        outputStream.flush();
//        outputStream.close();
//        workbook.close();
    }
}
