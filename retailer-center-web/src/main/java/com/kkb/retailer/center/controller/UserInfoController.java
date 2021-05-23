package com.kkb.retailer.center.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.retailer.center.api.UserInfoService;
import com.kkb.retailer.center.common.http.HttpResult;
import com.kkb.retailer.center.common.http.ResultEnum;
import com.kkb.retailer.center.common.pojo.UserInfo;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "用户管理")
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


    @ApiOperation(value = "用户分页查询",notes = "接受分页参数pageNum,pageSize")
    @GetMapping("/userList")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "param", name = "page", value = "第几页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "param", name = "pageSize", value = "每页显示多少条数据", required = true, dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "条件分页查询用户成功"),
            @ApiResponse(code = 500, message = "条件分页查询用户失败,后台服务出现异常"),
            @ApiResponse(code = 401, message = "代表此操作无权限访问"),
            @ApiResponse(code = 400, message = "表示请求参数错误"),
    })
    public HttpResult<Object> getPageInfo(@RequestParam(value="page",defaultValue="1") int pageNo,
                                          @RequestParam(value="pageSize",defaultValue="10")int pageSize){
        if(pageNo==0){
            return HttpResult.otherError(ResultEnum.NOT_PARAM);
        }
        PageInfo<UserInfo> pageInfo = userInfoService.getUserInfoPage(pageNo,pageSize);
        return HttpResult.success(pageInfo);
    }
}
