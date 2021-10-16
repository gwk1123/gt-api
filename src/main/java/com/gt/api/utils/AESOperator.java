package com.gt.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * The type Aes operator.
 */
public class AESOperator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AESOperator.class);

    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    //private String sKey = "1234567890123456";
    private byte[] ivParameter = new byte[16];
    private static AESOperator instance = null;
    private AESOperator() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static  AESOperator getInstance() {
        if (instance == null) {
            instance = new  AESOperator();
        }
        return instance;
    }


    /**AES/CBC/PKCS5Padding加密并base64转码
     *
     * @param sSrc 内容
     * @param sKey 秘钥
     * @return string
     * @throws Exception the exception
     */
    public  String jdk8encrypt(String sSrc,String sKey) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted  = cipher.doFinal(sSrc.getBytes("utf-8"));

        return  Base64.getEncoder().encodeToString(encrypted);// 此处使用BASE64做转码。
    }

    /**
     * AES/CBC/PKCS5Padding解密并base64并解码
     * @param sSrc 内容
     * @param sKey 秘钥
     * @return string
     * @throws Exception the exception
     */
    public String jdk8decrypt(String sSrc,String sKey) throws Exception {
        byte[] raw = sKey.getBytes("ASCII");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivParameter);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = Base64.getDecoder().decode(sSrc.getBytes());// 先用base64解密
        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original, "utf-8");
        return originalString;
    }


    /**AES/CBC/PKCS5Padding加密并base64转码
     *
     * @param sSrc 内容
     * @param sKey 秘钥
     * @return string
     * @throws Exception the exception
     */
    public  String encrypt(String sSrc,String sKey) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted  = cipher.doFinal(sSrc.getBytes("utf-8"));
        return new BASE64Encoder().encodeBuffer(encrypted);// 此处使用BASE64做转码。
    }

    /**
     * AES/CBC/PKCS5Padding解密并base64并解码
     * @param sSrc 内容
     * @param sKey 秘钥
     * @return string
     * @throws Exception the exception
     */
    public String decrypt(String sSrc,String sKey) throws Exception {
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {System.out.println(1-(7*0.01));

        //String cSrc = Tool.getFileContentByAddress("E:/hello_2.txt");
        String cSrc = "Hello Word";
        String sKey = "1234567890123456";
        System.out.println(cSrc);
        cSrc =  AESOperator.getInstance().jdk8encrypt(cSrc,sKey);
        cSrc = "2IL6kpEa6qn8zyLfiigZf9yGkzFVwv7i22TTKLaZFyUkcg6hBlcYU+VDx4uS2yA5CxKukpX4jLGkd1Q3TRsb6c+rkSfFtD5snqEl3zTUBVYdf7QVmgGYJvJ5oPV+cq5C8eJfd0uUrrYEn8BJo5Mwglr7QhUNH82jirInS6E7zYPxFuxhp/mAmDGzrVwC30EyiAauyYFYN036jiJklgEDik45M0NS6QbDps8dsMflvH2yjZ3D1GOSpGzWLan7F0RWziQKm/uAzJGm23H9CVT7VRM+8QrJzaTSCXXzEuxDX8mV6lUGqqh1+tdvBHJ3wRH2hTudlOiWlYFEWrL1LLsps8uzojdsVj5nlMGWPMg8JEGBCJpkmiuzdUNu1Jy/9KcqYc06Q+tFjMI3+oqPgK+m/+BzXo/m5PwjYdiO0bYuFCA=";
        System.out.println(cSrc);
        System.out.println( AESOperator.getInstance().jdk8decrypt(cSrc,sKey));

    }
}
