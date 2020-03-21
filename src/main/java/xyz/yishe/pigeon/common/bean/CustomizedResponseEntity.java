package xyz.yishe.pigeon.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 返回消息
 *
 * @author owen
 * @version 2016-04-19-09:30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("通用响应体")
public class CustomizedResponseEntity<T> extends BaseBean {
    public static final int SUCCESS = 200;                   // 成功
    public static final int FAIL = 201;                      // 业务失败
    public static final int SESSION_TIMEOUT = 202;           // 会话过期
    public static final int USER_LOCKED = 203;              // 用户锁定

    public static final int ARGS_NOT_VALID_ERROR = 9998;     // 参数不合法
    public static final int UNKNOWN_ERROR = 9999;            // 未知异常

    @ApiModelProperty("状态码：200 成功，201 失败，202 会话过期")
    private Integer retCode;

    @ApiModelProperty("原因")
    private String retMsg;

    @ApiModelProperty("返回对象")
    private T data;

    /**
     * ok
     */
    public static CustomizedResponseEntity ok() {
        return CustomizedResponseEntity.builder()
                .retCode(SUCCESS)
                .retMsg("操作成功")
                .build();
    }

    /**
     * ok
     */
    public static <T> CustomizedResponseEntity<T> ok(T data) {
        return CustomizedResponseEntity.<T>builder()
                .data(data)
                .retCode(SUCCESS)
                .retMsg("操作成功")
                .build();
    }

    /**
     * ok
     */
    public static <T> CustomizedResponseEntity<T> ok(String retMsg) {
        return CustomizedResponseEntity.<T>builder()
                .retCode(SUCCESS)
                .retMsg(retMsg)
                .build();
    }

    /**
     * ok
     *
     * @param retMsg 返回信息
     * @param data   返回数据
     * @param <T>    返回数据类型
     * @return
     */
    public static <T> CustomizedResponseEntity<T> ok(String retMsg, T data) {
        return CustomizedResponseEntity.<T>builder()
                .data(data)
                .retCode(SUCCESS)
                .retMsg(retMsg)
                .build();
    }

    /**
     * fail
     *
     * @param retCode
     * @param retMsg
     * @return
     */
    public static CustomizedResponseEntity fail(Integer retCode, String retMsg) {
        return CustomizedResponseEntity.builder()
                .retCode(retCode)
                .retMsg(retMsg)
                .build();
    }


    /**
     * fail
     *
     * @param failMsg
     * @return
     */
    public static CustomizedResponseEntity fail(String failMsg) {
        return CustomizedResponseEntity.builder()
                .retCode(FAIL)
                .retMsg(failMsg)
                .build();
    }

    /**
     * 参数无效异常
     *
     * @param retMsg
     * @return
     */
    public static CustomizedResponseEntity argsNotValid(String retMsg) {
        return fail(ARGS_NOT_VALID_ERROR, retMsg);
    }


    /**
     * 会话过期异常（未登录)
     *
     * @param retMsg
     * @return
     */
    public static CustomizedResponseEntity timeout(String retMsg) {
        return fail(SESSION_TIMEOUT, retMsg);
    }

    /**
     * 未知异常
     *
     * @param retMsg
     * @return
     */
    public static CustomizedResponseEntity unknownError(String retMsg) {
        return fail(UNKNOWN_ERROR, retMsg);
    }
}




