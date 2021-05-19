package com.kkb.retailercenter.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.retailer.center.api.UserInfoService;
import com.kkb.retailer.center.common.http.HttpResult;
import com.kkb.retailer.center.common.pojo.UserInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {
    @Reference
    private UserInfoService userInfoService;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/allUser")
    public List<UserInfo> getAllUserInfo(){
        return userInfoService.selectAll();
    }

    /**
     * 增加用户
     * @param userInfo
     * @return
     */
    @PostMapping("/addUser")
    public int addUserInfo(@RequestBody UserInfo userInfo){

        return userInfoService.addUserInfo(userInfo);
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @PutMapping("/updateUser")
    public int updateUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserInfo(userInfo);
    }

    /**
     * 删除用户
     * localhost:8100/api/users/delUserById/2
     * @param id 用户主键ID
     * @return
     */
    @DeleteMapping("/delUserById/{id}")
    public int deleteUserInfo(@PathVariable Long id){
        return userInfoService.deleteUserInfo(id);
    }

    @GetMapping("/userList")
    public HttpResult<Object> getPageInfo(@RequestParam(value="page",defaultValue="1") int pageNo,
                                          @RequestParam(value="pageSize",defaultValue="10")int pageSize){
        PageInfo<UserInfo> pageInfo = userInfoService.getUserInfoPage(pageNo,pageSize);
        return HttpResult.success(pageInfo);
    }
}
