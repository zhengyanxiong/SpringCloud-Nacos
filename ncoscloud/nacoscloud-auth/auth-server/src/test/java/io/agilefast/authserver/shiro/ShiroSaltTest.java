package io.agilefast.authserver.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

/**
 * @Author: Bernie
 * @Date: 2019-08-15 15:29
 */
public class ShiroSaltTest {
    public final static String hashAlgorithmName = "SHA-256";
    @Test
    public void shiroTest(){
        String password = "admin";
        String salt = "YzcmCZNvbXocrsz9dm8e";

        int hashIterations = 16;

        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);

        String encode = simpleHash.toString();

        //打印最终结果
        System.out.println(encode);

        SimpleHash simpleHash1 = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);


        System.out.println("e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b".equals(simpleHash1.toString()));

    }
}
