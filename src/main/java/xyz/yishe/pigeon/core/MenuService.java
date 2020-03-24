package xyz.yishe.pigeon.core;

import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.dao.jpa.entity.MenuEntity;
import xyz.yishe.pigeon.server.request.MenuCreateRequest;
import xyz.yishe.pigeon.server.request.MenuQueryRequest;
import xyz.yishe.pigeon.server.request.MenuUpdateRequest;
import xyz.yishe.pigeon.server.response.MenuQueryResponse;

import java.util.List;

/**
 * 菜单
 *
 * @author owen
 * @date 2020-03-21 10:16
 */
public interface MenuService {
    /**
     * 查询菜单列表
     *
     * @param menuQueryRequest
     * @return
     */
    List<MenuQueryResponse> query(MenuQueryRequest menuQueryRequest);

    /**
     * 创建菜单
     *
     * @param menuCreateRequest
     */
    void create(MenuCreateRequest menuCreateRequest);

    /**
     * 更新菜单
     *
     * @param menuUpdateRequest
     */
    void update(MenuUpdateRequest menuUpdateRequest);

    /**
     * 查询菜单详情
     *
     * @param menuId
     * @return
     * @throws BizException
     */
    MenuEntity load(Integer menuId) throws BizException;

    /**
     * 查询菜单详情
     *
     * @param menuId
     * @return
     */
    MenuEntity get(Integer menuId);
}
