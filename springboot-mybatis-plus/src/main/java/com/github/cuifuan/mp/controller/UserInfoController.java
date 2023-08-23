package com.github.cuifuan.mp.controller;

import com.github.cuifuan.mp.domain.UserInfo;
import com.github.cuifuan.mp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    @GetMapping("/{id}")
    public UserInfo getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }
}
