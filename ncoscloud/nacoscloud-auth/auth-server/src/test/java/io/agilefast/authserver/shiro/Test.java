package io.agilefast.authserver.shiro;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    @org.junit.Test
    public void Test() {
        String password = "oauth2";
        System.out.println(password + " -> ");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);

    }
}
