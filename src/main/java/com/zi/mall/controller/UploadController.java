/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: UploadController
 * Author: Zi
 * Date: 2019/4/23 15:17
 * Description: 文件上传控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.utils.RandomUtils;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传控制器
 *
 * @author Zi
 * @create 2019/4/23
 * @since 1.0.0
 */
@Controller
public class UploadController {
    @Value("${upload.path}")
    private String uploadPath;

    @RequestMapping("/upload")
    @ResponseBody
    /**
     * 图片上传
     */
    public Map<String,Object> uploadFile(MultipartFile file) {
        //得到旧文件名
        String oldName = file.getOriginalFilename();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dirName = dateFormat.format(new Date());
        File dir = new File(uploadPath, dirName);
        //判断目录是否存在
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String newName = RandomUtils.createFileNameUseTime(oldName);
        File uploadFile = new File(dir, newName);
        HashMap<String, Object> map = new HashMap<>();
        try {
            file.transferTo(uploadFile);
            map.put("code",0);
            map.put("path",dirName+"/"+newName);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code",500);
        }
        return map;
    }
    /**
     * 图片显示
     */
    @RequestMapping("showImage")
    public ResponseEntity showImage(String path) {
        // 获得需要下载的文件对象
        File file = new File(uploadPath,path);
        // 将下载的文件，封装byte[]
        byte[] bytes = null;
        try {
            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 创建封装响应头信息的对象
        HttpHeaders header = new HttpHeaders();
        // 封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置下载的文件的名称
        header.setContentDispositionFormData("attachment", "123.jpg");
        // 创建ResponseEntity对象
        ResponseEntity entity = new ResponseEntity(bytes, header, HttpStatus.CREATED);
        return entity;
    }
}
