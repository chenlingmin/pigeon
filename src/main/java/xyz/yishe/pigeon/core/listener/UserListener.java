package xyz.yishe.pigeon.core.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xyz.yishe.pigeon.core.UserService;
import xyz.yishe.pigeon.core.event.ShopBanEvent;
import xyz.yishe.pigeon.core.event.ShopCreateEvent;
import xyz.yishe.pigeon.server.request.UserCreateRequest;

/**
 * @author owen
 * @date 2020-03-21 16:44
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserListener {
    private final UserService userService;

    /**
     * 监听店铺创建事件
     *
     * @param shopCreateEvent
     */
    @EventListener
    public void onShopCreate(ShopCreateEvent shopCreateEvent) {
        userService.create(shopCreateEvent.convert(UserCreateRequest::new));
    }

    /**
     * 监听店铺禁用事件
     *
     * @param shopBanEvent
     */
    @EventListener
    public void onShopBan(ShopBanEvent shopBanEvent) {
        String shopId = shopBanEvent.getShopId();
        userService.shopBan(shopId);
    }
}
