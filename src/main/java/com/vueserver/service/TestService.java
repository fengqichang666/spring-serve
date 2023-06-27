package com.vueserver.service;

import com.vueserver.mapper.TestMapper;
import com.vueserver.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;
    public Test getTest(String test){

        return testMapper.getTest(test);
    }
}
