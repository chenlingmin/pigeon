package xyz.yishe.pigeon.common.exception;

import lombok.Data;

/**
 * @author owen
 * @date 2018-09-08
 */
@Data
public class BizException extends RuntimeException {
    /**
     * 异常编码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    public BizException() {
        super();
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BizException(Throwable e) {
        super(e);
    }

}
