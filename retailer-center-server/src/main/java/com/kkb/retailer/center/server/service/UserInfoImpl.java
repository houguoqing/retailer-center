package com.kkb.retailer.center.server.service;

import com.kkb.retailer.center.api.UserInfoService;
import com.kkb.retailer.center.common.pojo.UserInfo;
import com.kkb.retailer.center.server.mappers.UserInfoMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class UserInfoImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int deleteUserInfo(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }
}
