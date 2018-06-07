package com.qiqi.meishijia.controller;

import com.qiqi.meishijia.common.Constants;
import com.qiqi.meishijia.core.Result;
import com.qiqi.meishijia.core.ResultGenerator;
import lib.utils.FileUtil;
import lib.utils.MD5Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController extends BaseController{

    @PostMapping("/image")
    public Result uploadImage(@RequestPart(name = "img_file") MultipartFile file){
        if(file.isEmpty()){
            return ResultGenerator.genFailResult("图片文件为空");
        }
        String imageName = MD5Util.MD5(System.currentTimeMillis() + "");
        try {
            FileUtil.saveImage(file.getBytes(), getApplicationPath()+ Constants.SLASH + Constants.FILE_BUCKET, imageName + Constants.IMG_SUFFIX);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult(Constants.URL_PREFIX + Constants.FILE_BUCKET + imageName + Constants.IMG_SUFFIX);
    }
}
