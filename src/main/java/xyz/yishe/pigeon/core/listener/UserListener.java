package xyz.yishe.pigeon.core.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xyz.yishe.pigeon.common.model.enums.UserStateEnum;
import xyz.yishe.pigeon.common.util.CommonUtils;
import xyz.yishe.pigeon.core.UserService;
import xyz.yishe.pigeon.core.event.ShopBanEvent;
import xyz.yishe.pigeon.core.event.ShopCreateEvent;
import xyz.yishe.pigeon.core.event.ShopPassEvent;
import xyz.yishe.pigeon.dao.jpa.entity.UserEntity;
import xyz.yishe.pigeon.dao.jpa.repository.UserRepository;
import xyz.yishe.pigeon.server.request.UserCreateRequest;

import java.util.List;

/**
 * @author owen
 * @date 2020-03-21 16:44
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserListener {
    private final UserService userService;
    private final UserRepository userRepository;

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
        List<UserEntity> userEntityList = userRepository.findByShopId(shopId);
        if (CommonUtils.isEmpty(userEntityList)) {
            return;
        }

        // 禁用用户
        userEntityList.forEach(user -> userService.ban(user.getId()));
    }

    /**
     * 监听店铺启用事件
     * 启用店铺负责人账号
     *
     * @param shopPassEvent
     */
    @EventListener
    public void onShopPass(ShopPassEvent shopPassEvent) {
        String phone = shopPassEvent.getPhone();
        UserEntity userEntity = userService.getByPhone(phone);
        if (CommonUtils.isNotEmpty(userEntity)) {
            userEntity.setState(UserStateEnum.OK.getValue());
            userRepository.save(userEntity);
        }
    }
}
