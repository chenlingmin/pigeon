package xyz.yishe.pigeon.core.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.common.model.enums.ShopStateEnum;
import xyz.yishe.pigeon.common.util.CommonUtils;
import xyz.yishe.pigeon.core.ShopService;
import xyz.yishe.pigeon.core.event.ShopCreateEvent;
import xyz.yishe.pigeon.dao.jpa.ShopEntity;
import xyz.yishe.pigeon.dao.jpa.repository.ShopRepository;
import xyz.yishe.pigeon.server.request.ShopCreateRequest;
import xyz.yishe.pigeon.server.response.ShopCreateResponse;

/**
 * @author owen
 * @date 2020-03-21 10:15
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public ShopCreateResponse create(ShopCreateRequest shopCreateRequest) {
        String phone = shopCreateRequest.getPhone();
        String contact = shopCreateRequest.getContact();

        // 重复性校验
        ShopEntity shopEntity = this.getByPhone(phone);
        if (CommonUtils.isEmpty(shopEntity)) {
            throw new BizException("店铺创建失败,联系人手机号码重复!");
        }

        // 构建实体
        shopEntity = shopCreateRequest.convert(ShopEntity::new);
        shopEntity.setState(ShopStateEnum.PENDING.getValue()); // 待认证
        shopEntity = shopRepository.save(shopEntity);
        String shopId = shopEntity.getId();

        // 发布店铺创建事件
        applicationEventPublisher.publishEvent(
                ShopCreateEvent.builder()
                        .shopId(shopId)
                        .contact(contact)
                        .phone(phone)
                        .build()
        );

        return ShopCreateResponse.builder().shopId(shopId).build();
    }

    /**
     * 查询店铺详情
     *
     * @param phone
     * @return
     */
    public ShopEntity getByPhone(String phone) {
        return shopRepository.findByPhone(phone).orElse(null);
    }
}
