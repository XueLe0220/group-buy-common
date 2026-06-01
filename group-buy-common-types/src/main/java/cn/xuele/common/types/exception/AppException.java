package cn.xuele.common.types.exception;

import cn.xuele.common.types.enums.ResponseCode;

import java.io.Serial;

/**
 * 拼团服务通用异常
 *
 * @author XueLe
 * @version 1.0.0
 * @since 2026/05/31 21:47
 */
public class AppException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5317680961212299217L;

    private final String code;
    private final String info;

    public AppException(ResponseCode responseCode) {
        super(responseCode.getInfo());
        this.code = responseCode.getCode();
        this.info = responseCode.getInfo();
    }

    public AppException(String code, String info) {
        super(info);
        this.code = code;
        this.info = info;
    }

    public AppException(String code, String info, Throwable cause) {
        super(info, cause);
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "AppException{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
