package com.sense.base.auth.response;

import lombok.Data;

@Data
public class Result<T> extends BasePageResult {

    private Integer code;

    private T data;

    private String msg;

    private long total;


    private static <T> Result<T> response(Integer code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    /**
     * 正常返回，带总记录数
     *
     * @param data
     * @param total
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data, long total) {
        Result<T> result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        result.setTotal(total);
        return result;
    }
}
