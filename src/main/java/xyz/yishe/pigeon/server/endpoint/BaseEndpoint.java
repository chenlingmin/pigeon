package xyz.yishe.pigeon.server.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.yishe.pigeon.common.util.CommonUtils;
import xyz.yishe.pigeon.config.handler.UserInfo;
import xyz.yishe.pigeon.config.handler.UserStorage;

import java.util.Optional;

/**
 * 获取用户信息
 *
 * @author panjianguo 2018-12-19 5:23 PM
 */
public class BaseEndpoint {
    @Autowired
    private UserStorage userStorage;

    /**
     * 获取用户编号
     *
     * @return
     */
    public String getUserId() {
        UserInfo user = this.getUser();
        if (CommonUtils.isNotEmpty(user)) {
            return user.getId();
        }
        return null;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    private UserInfo getUser() {
        return Optional.ofNullable(userStorage.getUser()).orElse(null);
    }
}
