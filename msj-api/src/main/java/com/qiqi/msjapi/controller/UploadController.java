package com.qiqi.msjapi.controller;

import com.qiqi.commonlib.common.Constants;
import com.qiqi.commonlib.lib.utils.ClassPathUtil;
import com.qiqi.commonlib.lib.utils.FileUtil;
import com.qiqi.commonlib.lib.utils.MD5Util;
import com.qiqi.msjapi.core.Result;
import com.qiqi.msjapi.core.ResultEnum;
import com.qiqi.msjapi.core.ResultGenerator;
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
