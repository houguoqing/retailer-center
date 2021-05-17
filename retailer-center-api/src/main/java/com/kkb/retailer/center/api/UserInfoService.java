package com.kkb.retailer.center.api;
import com.kkb.retailer.center.common.pojo.UserInfo;
import java.util.List;

public interface UserInfoService {
    List<UserInfo> selectAll();
}
