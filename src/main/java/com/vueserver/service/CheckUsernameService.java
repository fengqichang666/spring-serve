package com.vueserver.service;

import com.vueserver.mapper.CheckUsername;
import com.vueserver.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckUsernameService {
    @Autowired
    CheckUsername CheckUsername;
    public Integer Integer (String username ){
        return CheckUsername.CheckUsername(username);
    }
}
