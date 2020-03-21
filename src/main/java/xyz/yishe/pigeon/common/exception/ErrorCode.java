package xyz.yishe.pigeon.common.exception;

/**
 * 错误编码
 * 约定:
 * 1、特殊异常需要制定错误编码，前端需要根据错误编码来做逻辑判断
 * 2、业务异常无需指定编码，只需要将错误信息传给前端
 *
 * @author owen
 * @date 2019-01-03
 */
public class ErrorCode {
    public static final int SUCCESS = 0;                     // 成功

    public static final int SESSION_TIMEOUT_ERROR = 1000;    // 会话过期（未登陆）
    public static final int BUSINESS_ERROR = 1002;           // 业务异常


    public static final int ARGS_NOT_VALID_ERROR = 9998;     // 参数不合法
    public static final int UNKNOWN_ERROR = 9999;            // 未知异常
}
