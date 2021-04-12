package mytest.utils.encode;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Description
 * @ClassName RSAUtils
 * @Author wangDi
 * @date 2021-04-08 16:06
 */
public class RSAUtils {

    public static String RSA_ALGORITHM = "RSA";
    public static String UTF8 = "UTF-8";

    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEQ2v8j8UpjIEUUAFByG/joZIP4xOxxzE0NdLIwSDQMhTwGIPMNMZbqE8qL9UKGyV/HMvz0Hq+aXYyThN6XOJ1yBiRYyMGLkB2ozrc8Jwpfsz9i9F6kreyto7Um1yRhc9Pb9bkJ9x8MbwOVHq4/9RuvHPQ9d2MIsNL+epQuN0IEQIDAQAB";
    private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIRDa/yPxSmMgRRQAUHIb+Ohkg/jE7HHMTQ10sjBINAyFPAYg8w0xluoTyov1QobJX8cy/PQer5pdjJOE3pc4nXIGJFjIwYuQHajOtzwnCl+zP2L0XqSt7K2jtSbXJGFz09v1uQn3HwxvA5Uerj/1G68c9D13Ywiw0v56lC43QgRAgMBAAECgYBqze8Twh1akeViO8DoGC2SSdSjE6HBu7KWEKioCJywwuB5ibJUYoGTXnSfAoUsZgN/hAeGWWHlBVC3Cqlb9EnB13Y778Ol8CIbE2T+l1JrAb5jIsrlAQodJSDCJrqck3svP9jaNCwmA4Qo7r+wof8EsF2bUskhxZD1J6m4ltrLyQJBAOGVF+jNzzVSxlamd49P5VjskNcd9hvmikI4ZV/bWxaoHGBs9axHnYWi5cQ37z/LIgPBwiE2okMtC1wkuapCA+sCQQCWGQmNX+Cqi2X9p2CvtK7H4Yrp+qzbILEwf+w4paQTfzmpuTIJHpPPy/jh80j7hvg58my2E/kKML4rotti1fDzAkA/ImEssN07SU1lVvXDUFMaDiuDaUlGCcHMQshsiZH2x1oZyqT/cJOvoSW5QwZczldYwdO5Q/cp4eN6CHVGJ2+9AkBADVktMnAOd0RD1WyGLqWzeIUuSiH/tNjIaJ6modD93Pn/ep9mktzi/RktWwOXCsbc+532qVlKRviwaGQUrlWPAkEAnLlEcsUQSobDIjFR7QLihXbG5f1povl4uDUFli8mySLuWmPWJ+wMwESBLG97+cy/dmMnhawnZzFcWgAF8hMdZQ==";



    /**
     * 密钥长度，DSA算法的默认密钥长度是1024
     * 密钥长度必须是64的倍数，在512到65536位之间
     */
    private static final int KEY_SIZE = 1024;

//    public static void main(String[] args) throws Exception {
//        String password = "1234abcd5678";
//        KeyStore keys = createKeys();
//        byte[] publicKey = getPublicKey(keys);
//        byte[] privateKey = getPrivateKey(keys);
//        System.out.println("公钥：" + Base64.encode(publicKey));
//        System.out.println("私钥：" + Base64.encode(privateKey));
//
//        byte[] encryptByPublicKey = encryptByPublicKey(password.getBytes(), publicKey);
//        System.out.println("使用公钥加密后的数据：" + Base64.encode(encryptByPublicKey));
//
//        byte[] decryptByPrivateKey = decryptByPrivateKey(encryptByPublicKey, privateKey);
//        System.out.println("使用私钥解密后的数据：" + new String(decryptByPrivateKey));
//
//    }

    /**
     * 生成密钥对
     *
     * @return 密钥对对象
     * @throws NoSuchAlgorithmException
     */
    public static KeyStore createKeys() throws NoSuchAlgorithmException {
        //KeyPairGenerator用于生成公钥和私钥对。密钥对生成器是使用 getInstance 工厂方法
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        KeyStore keyStore = new KeyStore(publicKey, privateKey);
        return keyStore;
    }

    /**
     * 获取私钥
     *
     * @param keyStore
     * @return
     */
    private static byte[] getPrivateKey(KeyStore keyStore) {
        return ((RSAPrivateKey) keyStore.privateKey).getEncoded();
    }

    /**
     * 获取公钥
     *
     * @param keyStore
     * @return
     */
    private static byte[] getPublicKey(KeyStore keyStore) {
        return ((RSAPublicKey) keyStore.publicKey).getEncoded();
    }

    /**
     * 私钥加密
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key) throws Exception {

        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    private static byte[] encryptByPublicKey(byte[] data, byte[] key) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //初始化公钥,根据给定的编码密钥创建一个新的 X509EncodedKeySpec。
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        //数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] key) throws Exception {

        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //初始化公钥
        //密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        //产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        return cipher.doFinal(data);
    }


    //定义密钥类

    public static class KeyStore {
        private Object publicKey;
        private Object privateKey;

        public KeyStore() {
        }

        public KeyStore(Object publicKey, Object privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public Object getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(Object publicKey) {
            this.publicKey = publicKey;
        }

        public Object getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(Object privateKey) {
            this.privateKey = privateKey;
        }
    }
}