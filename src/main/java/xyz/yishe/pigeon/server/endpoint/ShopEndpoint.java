package xyz.yishe.pigeon.server.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.yishe.pigeon.common.bean.CustomizedResponseEntity;
import xyz.yishe.pigeon.core.ShopService;
import xyz.yishe.pigeon.server.request.ShopCreateRequest;
import xyz.yishe.pigeon.server.response.ShopCreateResponse;
import xyz.yishe.pigeon.server.response.UserCreateResponse;

import static xyz.yishe.pigeon.common.bean.CustomizedResponseEntity.ok;
import static xyz.yishe.pigeon.config.SpringSessionConfiguration.TOKEN_HEADER;

/**
 * @author owen
 * @date 2020-03-21 09:02
 */
@Api(tags = "店铺中心")
@Slf4j
@RequestMapping(value = "shop")
@RestController
@RequiredArgsConstructor
public class ShopEndpoint extends BaseEndpoint {
    private final ShopService shopService;

    @PostMapping("create")
    @ApiOperation("创建店铺")
    public CustomizedResponseEntity<ShopCreateResponse> create(
//            @RequestHeader(TOKEN_HEADER) String token,
            @RequestBody ShopCreateRequest shopCreateRequest) {
        return ok(shopService.create(shopCreateRequest));
    }

    @ApiOperation("禁用店铺")
    @PostMapping(value = "ban/{shopId}")
    public CustomizedResponseEntity<UserCreateResponse> ban(
            @RequestHeader(TOKEN_HEADER) String token, @PathVariable String shopId) {
        shopService.ban(shopId);
        return CustomizedResponseEntity.ok();
    }

    @ApiOperation("启用店铺")
    @PostMapping(value = "pass/{shopId}")
    public CustomizedResponseEntity<UserCreateResponse> pass(
            @RequestHeader(TOKEN_HEADER) String token, @PathVariable String shopId) {
        shopService.pass(shopId);
        return CustomizedResponseEntity.ok();
    }
}
