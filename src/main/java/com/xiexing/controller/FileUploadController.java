
package com.xiexing.controller;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/file")
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(description);
        // 如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            // 上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            // 上传文件名
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            File filePath = new File(path, fileName);
            // 判断路径是否存在，如果不存在就创建
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            // 将上传文件保存到目标文件中
            file.transferTo(new File(path + File.separator + fileName));
            request.setAttribute("fileName", fileName);
            return "download";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("fileName") String fileName) throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "UTF-8");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //application/octet-stream ： 二进制流数据(最常见的文件下载)
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
