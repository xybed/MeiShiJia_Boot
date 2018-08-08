package com.qiqi.msjback;

import com.qiqi.msjback.utils.EncryptUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsjBackApplicationTests {

    @Test
    public void contextLoads() {
        String username = "guest";
        String password = "111111";
        String salt = username + new SecureRandomNumberGenerator().nextBytes().toHex();
        System.out.println("加密盐："+salt);
        System.out.println("密码："+EncryptUtil.entryptPassword(password, salt));
    }

}
