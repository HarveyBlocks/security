package com.harvey.security.boot.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class WebSecurityConfigTest {

    @Test
    void testPasswordEncoder() {
        String password = "lisi";
        // BCrypt.gensalt()自动生成盐,每次生成的盐还不一样;

        System.out.println("password= "+password);
        String[] hashed = new String[10];
        for (int i = 0; i < 10; i++) {
            String salt = BCrypt.gensalt();
            hashed[i] = BCrypt.hashpw(password, salt);
            System.out.println("   ans  = "+hashed[i]);
        }
        // 校验密码
        boolean checkpw = false;
        for (int i = 0; i < 10; i++) {
            checkpw = BCrypt.checkpw(password,hashed[i]);
            if(!checkpw){
                break;
            }
        }
        System.out.println(checkpw);
    }
}