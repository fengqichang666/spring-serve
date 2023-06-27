package com.vueserver.controller;

import com.vueserver.common.ResultData;
import com.vueserver.common.ReturnCode;
import com.vueserver.pojo.Login;
import com.vueserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public ResultData login (@RequestBody Login login){
        Integer res = loginService.login(login.getUsername(),login.getPassword());
        if(res!=null){
            return ResultData.success(null);
        }else{
            return ResultData.fail(ReturnCode.USERNAME_OR_PASSWORD_ERROR.getCode(),ReturnCode.USERNAME_OR_PASSWORD_ERROR.getMessage());
        }
    }
}
