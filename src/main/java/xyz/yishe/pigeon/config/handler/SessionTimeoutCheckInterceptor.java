package xyz.yishe.pigeon.config.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.common.util.CommonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static xyz.yishe.pigeon.common.exception.ErrorCode.SESSION_TIMEOUT_ERROR;

/**
 * 会话超时检查拦截器
 */
@Component
@RequiredArgsConstructor
public class SessionTimeoutCheckInterceptor extends HandlerInterceptorAdapter {
    private final UserStorage userStorage;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse rsp, Object handler) throws BizException {
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }

        UserInfo user = userStorage.getUser(req);
        if (CommonUtils.isNotEmpty(user)) {
            return true;
        }
        throw new BizException(SESSION_TIMEOUT_ERROR, "会话过期，请重新登录");
    }
}
