package xyz.yishe.pigeon.core;

import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.dao.jpa.entity.UserEntity;
import xyz.yishe.pigeon.dao.jpa.entity.UserRoleEntity;
import xyz.yishe.pigeon.server.request.UserCreateRequest;
import xyz.yishe.pigeon.server.request.UserLoginRequest;
import xyz.yishe.pigeon.server.response.UserCreateResponse;

import java.util.List;

/**
 * @author owen
 * @date 2020-03-21 10:16
 */
public interface UserService {
    /**
     * 创建用户
     *
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
     * 查询用户详情
     *
     * @param userId
     * @return
     */
    UserEntity get(String userId);

    /**
     * 查询用户详情
     *
     * @param phone
     * @return
     */
    UserEntity getByPhone(String phone);

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     * @throws BizException
     */
    UserEntity load(String userId) throws BizException;

    /**
     * 授予角色
     *
     * @param userId 用户编号
     * @param roleId 角色编号
     */
    void authorize(String userId, List<Integer> roleId);

    /**
     * 查询用户角色
     * 过滤禁用的角色
     *
     * @param userId 用户编号
     * @return
     */
    List<UserRoleEntity> listUserRole(String userId);
}
