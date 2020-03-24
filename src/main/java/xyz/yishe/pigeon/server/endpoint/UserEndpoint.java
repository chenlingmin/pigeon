package xyz.yishe.pigeon.server.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.yishe.pigeon.common.bean.CustomizedResponseEntity;
import xyz.yishe.pigeon.config.handler.UserInfo;
import xyz.yishe.pigeon.config.handler.UserStorage;
import xyz.yishe.pigeon.core.UserService;
import xyz.yishe.pigeon.dao.jpa.entity.UserEntity;
import xyz.yishe.pigeon.server.request.UserCreateRequest;
import xyz.yishe.pigeon.server.request.UserLoginRequest;
import xyz.yishe.pigeon.server.response.UserCreateResponse;
import xyz.yishe.pigeon.server.response.UserLoginResponse;

import static xyz.yishe.pigeon.config.SpringSessionConfiguration.TOKEN_HEADER;

/**
 * @author owen
 * @date 2020-03-21 09:02
 */
@Api(tags = "用户中心")
@Slf4j
@RequestMapping(value = "user")
@RestController
@RequiredArgsConstructor
public class UserEndpoint extends BaseEndpoint {
    private final UserService userService;
    private final UserStorage userStorage;

    @ApiOperation("登录")
    @PostMapping(value = "login")
    public CustomizedResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        UserEntity userEntity = userService.login(userLoginRequest);

        // 构建用户登录响应
        UserLoginResponse userLoginResponse = UserLoginResponse.builder()
                .userId(userEntity.getId())
                .token(userStorage.getSession().getId()) // 令牌
                .build();

        // 缓存用户信息
        UserInfo userInfo = userEntity.convert(UserInfo::new);
        userStorage.setUser(userInfo);

        return CustomizedResponseEntity.ok(userLoginResponse);
    }

    @ApiOperation("创建用户")
    @PostMapping(value = "create")
    public CustomizedResponseEntity<UserCreateResponse> create(
//            @RequestHeader(TOKEN_HEADER) String token,
            @RequestBody UserCreateRequest userCreateRequest) {
        return CustomizedResponseEntity.ok(userService.create(userCreateRequest));
    }

    @ApiOperation("禁用用户")
    @PostMapping(value = "ban/{userId}")
    public CustomizedResponseEntity<UserCreateResponse> ban(
            @RequestHeader(TOKEN_HEADER) String token, @PathVariable String userId) {
        userService.ban(userId);
        return CustomizedResponseEntity.ok();
    }

    @ApiOperation("启用用户")
    @PostMapping(value = "pass/{userId}")
    public CustomizedResponseEntity<UserCreateResponse> pass(
            @RequestHeader(TOKEN_HEADER) String token, @PathVariable String userId) {
        userService.pass(userId);
        return CustomizedResponseEntity.ok();
    }
}
