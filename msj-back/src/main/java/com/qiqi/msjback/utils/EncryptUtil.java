package com.qiqi.msjback.utils;

import com.qiqi.msjback.common.Constants;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptUtil {

    public static String entryptPassword(String password, String salt){
        SimpleHash hash = new SimpleHash(Constants.ALGORITHM_NAME, password, ByteSource.Util.bytes(salt), Constants.ITERATIONS);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }

}
