package com.sense.base.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ResultCode implements ResultCodeInterface, Serializable {

    SUCCESS(200, "成功"),

    FAIL(-1, "操作失败"),
    ACCESS_DENIED(403, "权限不足，访问被拒绝")
    ;


    private int code;

    private String msg;


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 通过枚举值获取枚举
     * @param desc 枚举值
     * @return
     */
    public static ResultCode getEnumByValue(String desc) {
        ResultCode[] resultCodes = values();
        for (ResultCode resultCode : resultCodes) {
            if (resultCode.getMsg().equals(desc)) {
                return resultCode;
            }
        }
        return null;
    }

    /**
     * 通过枚举键获取枚举
     * @param key 枚举键
     * @return
     */
    public static ResultCode getEnumByKey(int key) {
        ResultCode[] resultCodes = values();
        for (ResultCode resultCode : resultCodes) {
            if (resultCode.getCode()==key) {
                return resultCode;
            }
        }
        return null;
    }
}
