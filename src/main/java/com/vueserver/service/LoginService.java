package com.vueserver.service;

import com.vueserver.mapper.LoginMapper;
import com.vueserver.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;
    public Integer login (String username , String password){
        return loginMapper.login(username,password);
    }
}
