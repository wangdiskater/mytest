package mytest.encrypt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mytest.utils.encode.AESUtil;
import mytest.utils.encode.RSAHelper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 模拟使用AES + RSA混合加密
 * @ClassName EncryptTest
 * @Author wangDi
 * @date 2021-04-12 14:58
 */
public class EncryptTest {

    /**
     * 6. client使用aesKey对json数据进行加密得到密文(data)
     *
     * 7. client使用sever的RSA公钥对aesKey进行加密(encryptkey)
     *
     * 8. 分别将data和encryptkey作为参数传输给服务器端
     *
     */
    @Test
    void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        MyData myData = new MyData();
        List<String> strings = new ArrayList<>();
        strings.add("你");
        strings.add("是");
        strings.add("猪");
        strings.add("吗");
        strings.add("？");
        String s = objectMapper.writeValueAsString(strings);
        //client使用aesKey对json数据进行加密得到密文
        String data = AESUtil.encrypt(s, "");
        myData.setData(data);

        //     * 7. client使用sever的RSA公钥对aesKey进行加密(encryptkey)
        String encipher = RSAHelper.encipher(AESUtil.AESKeyBase64, RSAHelper.PUBLIC_KEY_VALUES);
        myData.setEncryptkey(encipher);

        System.out.println(myData);


        //服务端解密
        toServer(myData);

    }

    private void toServer(MyData myData) {
        // 获取AES密钥
        String encryptkey = myData.getEncryptkey();
        String AESKey = RSAHelper.decipher(encryptkey, RSAHelper.PRIVATE_KEY_VALUES);

        // 解密数据
        String data = myData.getData();
        String decrypt = AESUtil.decrypt(data, AESKey);
        System.out.println("解密数据");
        System.out.println(decrypt);

    }



    @Test
     void test2() {
        String value = "你炸了";
        for (int i = 0; i < 10 ; i++) {
//            String encrypt = AESUtil.encrypt(value, null);
//            System.out.println(encrypt);

            String encrypt = RSAHelper.encipher(value, RSAHelper.PUBLIC_KEY_VALUES);
            System.out.println(encrypt);

        }

    }

}
