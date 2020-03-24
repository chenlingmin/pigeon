package xyz.yishe.pigeon.core;

import xyz.yishe.pigeon.server.request.RoleCreateRequest;

import java.util.List;

/**
 * 角色业务类
 *
 * @author owen
 * @date 2020-03-21 10:16
 */
public interface RoleService {
    /**
     * 创建角色
     *
     * @param roleCreateRequest
     * @return
     */
    void create(RoleCreateRequest roleCreateRequest);

    /**
     * 启用角色
     *
     * @param roleId
     */
    void pass(Integer roleId);

    /**
     * 禁用角色
     *
     * @param roleId
     */
    void ban(Integer roleId);

    /**
     * 配置角色，菜单映射
     *
     * @param roleId
     * @param menuIdList
     */
    void deployRoleMenu(Integer roleId, List<Integer> menuIdList);
}
