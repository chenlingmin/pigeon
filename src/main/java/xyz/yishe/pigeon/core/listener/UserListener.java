package xyz.yishe.pigeon.core.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xyz.yishe.pigeon.core.UserService;
import xyz.yishe.pigeon.core.event.ShopCreateEvent;

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
    public void onShopCreate(ShopCreateEvent shopCreateEvent){

    }
}
