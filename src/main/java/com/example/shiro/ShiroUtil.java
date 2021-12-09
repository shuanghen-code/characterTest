package com.example.shiro;

import com.example.util.Constants;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.util.DigestUtils;

public class ShiroUtil {
    /**
     * 传入一个明文返回一个加密之后的密文
     */
    public static String getciphertext(String phertext) {
        String ciphertext = DigestUtils.md5DigestAsHex(phertext.getBytes());
        return ciphertext;
    }

    /**
     * 加盐加密
     *
     * @param salt
     * @param message
     * @return
     */

    public static String encryptionBySalt(String salt, String message) {
        //String algorithmName 加密算法, Object source 明文, Object salt 盐值, int hashIterations 加密次数
        String algorithmName = Constants.algorithmName;
        int hashIterations = Constants.hashIterations;
        SimpleHash simpleHash = new SimpleHash(algorithmName, message, salt, hashIterations);
        return simpleHash.toString();
    }

}
