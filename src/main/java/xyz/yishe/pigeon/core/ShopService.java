package xyz.yishe.pigeon.core;

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
}
