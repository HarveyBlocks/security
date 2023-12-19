package com.harvey.security.boot.service;

import com.harvey.security.boot.dao.UserDao;
import com.harvey.security.boot.pojo.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2023-12-18 14:52
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO userDTO;
        // 数据库中依据用户名查找用户信息
        if((userDTO = userDao.getUserByUsername(username))==null){
            return null;// 由认证流程, 返回null将有provider抛出异常
        }
        List<String> permissions = userDao.findPermissionsByUserId(userDTO.getId());
        return org.springframework.security.core.userdetails.User
                .withUsername(username).password(userDTO.getPassword())
                .authorities(permissions.toArray(new String[]{})).build();
    }
}
