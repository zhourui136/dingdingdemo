package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserCreateRequest;
import com.dingtalk.api.request.OapiUserDeleteRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserUpdateRequest;
import com.dingtalk.api.response.OapiUserCreateResponse;
import com.dingtalk.api.response.OapiUserDeleteResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserUpdateResponse;
import com.entity.User;
import com.enums.UserUrlEnum;
import com.service.UserService;
import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-14 下午4:08
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 获取accessToken,注意正是代码要有异常流处理
     */
    private static final String ACCESS_TOKEN = AccessTokenUtil.getToken();

    @Override
    public Boolean saveUser() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(UserUrlEnum.CREATE_USER_URL.getMessage());
        OapiUserCreateRequest request = new OapiUserCreateRequest();
        request.setUserid("zhangsan");
        request.setMobile("18347241346");
        request.setName("张三");
        // 需要用字符串， "[100,200]" 这种格式
        List<Long> departments = new ArrayList<Long>();
        departments.add(1L);
        request.setDepartment(JSON.toJSONString(departments));
        OapiUserCreateResponse response = client.execute(request, ACCESS_TOKEN);
        return response.isSuccess();
    }

    @Override
    public Boolean deleteUser() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(UserUrlEnum.DELETE_USER_URL.getMessage());
        OapiUserDeleteRequest request = new OapiUserDeleteRequest();
        request.setUserid("zhangsan");
        request.setHttpMethod("GET");
        OapiUserDeleteResponse response = client.execute(request, ACCESS_TOKEN);
        return response.isSuccess();
    }

    @Override
    public User getUser() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(UserUrlEnum.GET_USER_URL.getMessage());
        OapiUserGetRequest request = new OapiUserGetRequest();
        request.setUserid("zhangsan");
        request.setHttpMethod("GET");
        OapiUserGetResponse response = client.execute(request, ACCESS_TOKEN);
        User user = new User();
        return user;
    }

    @Override
    public Boolean updateUser() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(UserUrlEnum.UPDATE_USER_URL.getMessage());
        OapiUserUpdateRequest request = new OapiUserUpdateRequest();
        request.setUserid("zhangsan");
        request.setName("张三");
        OapiUserUpdateResponse response = client.execute(request, ACCESS_TOKEN);
        return response.isSuccess();
    }
}
