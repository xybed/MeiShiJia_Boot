package com.qiqi.msjapi.service.impl;

import com.qiqi.msjapi.core.ResultEnum;
import com.qiqi.msjapi.core.ServiceException;
import com.qiqi.msjapi.service.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public String getApplicationPath() {
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists())
                path = new File("");
            return path.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ServiceException(ResultEnum.APPLICATION_PATH_ERROR);
        }
    }
}
