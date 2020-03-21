package xyz.yishe.pigeon.config.handler;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.yishe.pigeon.common.util.CommonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 用户会话存储类
 *
 * @author owen
 */
@Data
@Slf4j
@Component
public class UserStorage {
    private final String CERES_USER = "_USER";

    public UserStorage() {
    }

    /**
     * 获取当前登录用户会话信息
     */
    public UserInfo getUser(HttpServletRequest request) {
        return (UserInfo) request.getSession().getAttribute(CERES_USER);
    }

    /**
     * 获取当前登录用户会话信息
     */
    public UserInfo getUser() {
        return (UserInfo) getSession().getAttribute(CERES_USER);
    }

    /**
     * 设置当前登录用户会话信息
     */
    public void setUser(UserInfo user) {
        getSession().setAttribute(CERES_USER, user);
    }

    /**
     * 清除当前登录用户会话信息
     */
    public void clearUser() {
        UserInfo user = this.getUser();
        if (CommonUtils.isNotEmpty(user)) {
            log.info("用户登出! 昵称：" + user.getNickname());
        }

        getSession().invalidate();
    }

    /**
     * 获取HttpSession
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取HttpServletRequest
     */
    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();
    }
}
