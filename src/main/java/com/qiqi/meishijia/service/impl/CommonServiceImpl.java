package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.core.ResultEnum;
import com.qiqi.meishijia.core.ServiceException;
import com.qiqi.meishijia.service.CommonService;
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
