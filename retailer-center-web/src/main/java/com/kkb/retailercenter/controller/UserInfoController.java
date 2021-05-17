package com.kkb.retailercenter.controller;

import com.kkb.retailer.center.api.UserInfoService;
import com.kkb.retailer.center.common.pojo.UserInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {
    @Reference
    private UserInfoService userInfoService;

    @GetMapping("/allUser")
    public List<UserInfo> getAllUserInfo(){
        return userInfoService.selectAll();
    }
}
