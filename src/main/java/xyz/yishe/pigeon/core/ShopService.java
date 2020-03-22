package xyz.yishe.pigeon.core;

import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.dao.jpa.entity.ShopEntity;
import xyz.yishe.pigeon.server.request.ShopCreateRequest;
import xyz.yishe.pigeon.server.response.ShopCreateResponse;

/**
 * @author owen
 * @date 2020-03-21 10:14
 */
public interface ShopService {
    /**
     * 创建店铺
     *
     * @param shopCreateRequest
     * @return
     */
    ShopCreateResponse create(ShopCreateRequest shopCreateRequest);

    /**
     * 审核通过
     *
     * @param shopId
     */
    void pass(String shopId);

    /**
     * 禁用店铺
     *
     * @param shopId
     */
    void ban(String shopId);

    /**
     * 查询店铺详情
     *
     * @param shopId
     * @return
     */
    ShopEntity get(String shopId);

    /**
     * 查询店铺详情
     *
     * @param shopId
     * @return
     * @throws BizException
     */
    ShopEntity load(String shopId) throws BizException;
}
