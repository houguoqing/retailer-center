package com.kkb.retailer.center.api;
import com.github.pagehelper.PageInfo;
import com.kkb.retailer.center.common.pojo.UserInfo;
import java.util.List;

public interface UserInfoService {
    List<UserInfo> selectAll();

    int addUserInfo(UserInfo userInfo);

    int updateUserInfo(UserInfo userInfo);

    int deleteUserInfo(Long id);

    PageInfo<UserInfo> getUserInfoPage(Integer pageNo, Integer pageNum);
}
