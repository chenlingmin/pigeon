package xyz.yishe.pigeon.core;

import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.dao.jpa.entity.UserEntity;
import xyz.yishe.pigeon.server.request.UserCreateRequest;
import xyz.yishe.pigeon.server.request.UserLoginRequest;
import xyz.yishe.pigeon.server.response.UserCreateResponse;

/**
 * @author owen
 * @date 2020-03-21 10:16
 */
public interface UserService {
    /**
     * 创建用户
     * @param userCreateRequest
     * @return
     */
    UserCreateResponse create(UserCreateRequest userCreateRequest);

    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @return
     */
    UserEntity login(UserLoginRequest userLoginRequest);

    /**
     * 启用用户
     *
     * @param userId
     */
    void pass(String userId);

    /**
     * 禁用用户
     *
     * @param userId
     */
    void ban(String userId);

    /**
     * 店铺禁用
     *
     * @param shopId
     */
    void shopBan(String shopId);

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     */
    UserEntity get(String userId);

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     * @throws BizException
     */
    UserEntity load(String userId) throws BizException;
}
