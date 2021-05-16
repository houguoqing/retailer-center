package com.kkb.retailer.center.server.service;

import com.kkb.retailer.center.api.TestService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getMessage() {
        return "hello 20210516";
    }
}
