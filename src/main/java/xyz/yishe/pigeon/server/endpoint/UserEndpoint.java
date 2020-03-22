package xyz.yishe.pigeon.server.endpoint;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yishe.pigeon.core.UserService;

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


}
