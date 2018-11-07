package com.qiqi.commonlib.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class ClassPathUtil {
    public static String getApplicationPath() {
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
