package com.qiqi.meishijia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String getApplicationPath(){
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists())
                path = new File("");
            return path.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
