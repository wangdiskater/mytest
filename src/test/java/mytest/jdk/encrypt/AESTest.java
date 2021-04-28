package mytest.jdk.encrypt;

import mytest.utils.encode.AES256Utils;
import mytest.utils.encode.AESUtil;
import org.junit.jupiter.api.Test;

/**
 * @Description
 * @ClassName AESTest
 * @Author wangDi
 * @date 2021-04-12 11:35
 */
public class AESTest {

    @Test
    void encryptTest1() {
        String password = "wangdi";
        String encryptValue = AESUtil.encrypt("你是猪吗？", password);
        String decrypt = AESUtil.decrypt(encryptValue, password);
        System.out.println(decrypt);

    }

    @Test
    void encryptTest2() {
        String str = "qUQ5nmlNO6IyohGZwwu1GA==";
        String s = AES256Utils.aesDecodeStr(str, AES256Utils.AESPassword);


        String phone = "15810897512";
        String s1 = AES256Utils.aesEncryptStr(phone, AES256Utils.AESPassword);

        System.out.println(s1);

    }


}
