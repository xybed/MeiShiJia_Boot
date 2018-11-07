package com.qiqi.msjapi.controller;

import com.qiqi.commonconfig.common.Constants;
import com.qiqi.commonconfig.common.Result;
import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ResultGenerator;
import com.qiqi.commonlib.utils.ClassPathUtil;
import com.qiqi.commonlib.utils.FileUtil;
import com.qiqi.commonlib.utils.MD5Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/image")
    public Result uploadImage(@RequestPart(name = "img_file") MultipartFile file){
        if(file.isEmpty()){
            return ResultGenerator.genFailResult(ResultEnum.IMAGE_FILE_NULL);
        }
        String imageName = MD5Util.MD5(System.currentTimeMillis() + "");
        try {
            FileUtil.saveImage(file.getBytes(), ClassPathUtil.getApplicationPath() + Constants.SLASH + Constants.IMAGE_BUCKET_AVATAR,
                    imageName + Constants.IMG_SUFFIX);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(ResultEnum.IMAGE_SAVE_ERROR);
        }
        return ResultGenerator.genSuccessResult(Constants.URL_PREFIX + Constants.IMAGE_BUCKET_AVATAR + imageName + Constants.IMG_SUFFIX);
    }
}
