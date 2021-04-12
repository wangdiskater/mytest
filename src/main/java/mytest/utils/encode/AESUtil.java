package mytest.utils.encode;

/**
 * @Description
 * @ClassName AESUtil
 * @Author wangDi
 * @date 2021-04-12 11:23
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @version V1.0
 * @desc AES 加密工具类
 */
public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";

    //默认的加密算法
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static final String AESKeyBase64 = "54aGNAXCV/TsWDYlqL8Vhg==";


    private static Map<String, SecretKeySpec> map = new HashMap<>();
    /**
     * AES 加密操作
     *
     * @param content  待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {

            // 创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            byte[] byteContent = content.getBytes("utf-8");

            // 初始化为加密模式的密码器
//            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());

            // 加密
            byte[] result = cipher.doFinal(byteContent);
            return Base64.getEncoder().encodeToString(result);
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey());
//            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] decode = Base64.getDecoder().decode(content);
            byte[] result = cipher.doFinal(decode);

            return new String(result, "utf-8");
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

//    /**
//     * 生成加密秘钥
//     *
//     * @return
//     */
//    private static SecretKeySpec getSecretKey(String password) {
//        //返回生成指定算法密钥生成器的 KeyGenerator 对象
//        SecretKeySpec secretKeySpec1 = map.get(password);
//        if (secretKeySpec1 != null) {
//            return secretKeySpec1;
//        }
//
//        KeyGenerator kg = null;
//        try {
//            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
//            //AES 要求密钥长度为 128
//            kg.init(128, new SecureRandom(password.getBytes()));
//            //生成一个密钥
//            SecretKey secretKey = kg.generateKey();
//
//            // 转换为AES专用密钥
//            byte[] encoded = secretKey.getEncoded();
//            SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, KEY_ALGORITHM);
//            // 保存密钥
//            map.put(password,secretKeySpec);
//            return secretKeySpec;
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    /**
     * 固定
     * @return
     */
    private static SecretKeySpec getSecretKey() {
        byte[] decode = Base64.getDecoder().decode(AESKeyBase64);
        SecretKeySpec secretKeySpec = new SecretKeySpec(decode, KEY_ALGORITHM);

        return secretKeySpec;
    }


}