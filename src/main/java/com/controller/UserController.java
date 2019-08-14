package com.controller;

import com.entity.User;
import com.service.UserService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-14 下午4:03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public Boolean saveUser() throws ApiException {
        return userService.saveUser();
    }

    @PostMapping("/deleteUser")
    public Boolean deleteUser() throws ApiException {
        return userService.deleteUser();
    }

    @PostMapping("/getUser")
    public User getUser() throws ApiException {
        return userService.getUser();
    }

    @PostMapping("/updateUser")
    public Boolean updateUser() throws ApiException {
        return userService.updateUser();
    }
}
