package xyz.yishe.pigeon.config.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import xyz.yishe.pigeon.common.bean.CustomizedResponseEntity;
import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.common.util.CommonUtils;

import static xyz.yishe.pigeon.common.exception.ErrorCode.SESSION_TIMEOUT_ERROR;


@Slf4j
@RestController
@ControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler({
            Exception.class,
            MethodArgumentNotValidException.class
    })
    public final CustomizedResponseEntity customHandleException(Exception ex, WebRequest request) {

        if (ex instanceof MethodArgumentNotValidException) {
            return CustomizedResponseEntity.argsNotValid(((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().stream()
                    .findFirst().map(DefaultMessageSourceResolvable::getDefaultMessage).orElse("参数不合法"));
        } else if (ex instanceof BizException) {
            final Integer code = ((BizException) ex).getCode();

            // 会话过期
            if (CommonUtils.isNotEmpty(code) && SESSION_TIMEOUT_ERROR == code) {
                return CustomizedResponseEntity.timeout(((BizException) ex).getMsg());
            }

            // 业务异常
            return CustomizedResponseEntity.fail(((BizException) ex).getMsg());
        } else {
            log.warn("发生未知异常 e: {}", ex);
            return CustomizedResponseEntity.unknownError(ex.getMessage());
        }
    }
}