package com.gordon.petStore.controller;

import com.gordon.petStore.request.UserRequest;
import com.gordon.petStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 18:29
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    //注册
    @PostMapping("/sign")
    public ResponseEntity signIn(UserRequest userRequest){
        userService.signIn(userRequest);
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity login(UserRequest userRequest){
        return null;

    }



    //登录

    //登出

    //重置密码
}
