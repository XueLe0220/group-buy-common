package cn.xuele.common.types.response;

import cn.xuele.common.types.enums.ResponseCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通用响应包装。
 *
 * @param <T> 业务数据类型
 */
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 7000723935764546321L;

    private String code;
    private String info;
    private T data;

    public Response() {
    }

    public Response(String code, String info, T data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), data);
    }

    public static <T> Response<T> failure(ResponseCode responseCode) {
        return new Response<>(responseCode.getCode(), responseCode.getInfo(), null);
    }

    public static <T> Response<T> failure(String code, String info) {
        return new Response<>(code, info, null);
    }

    public static <T> Response<T> failure(String code, String info, T data) {
        return new Response<>(code, info, data);
    }

    public boolean isSuccess() {
        return ResponseCode.SUCCESS.getCode().equals(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
