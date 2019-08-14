package com.service;

import com.entity.User;
import com.taobao.api.ApiException;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-14 下午4:07
 */
public interface UserService {
    /**
     * 钉钉新增用户
     *
     * @return Boolean
     */
    Boolean saveUser() throws ApiException;
    /**
     * 删除用户
     *
     * @return Boolean
     */
    Boolean deleteUser() throws ApiException;

    /**
     * 查看用户详情
     *
     * @return User
     */
    User getUser() throws ApiException;

    /**
     * 更新用户信息
     *
     * @return Boolean
     */
    Boolean updateUser() throws ApiException;
}
