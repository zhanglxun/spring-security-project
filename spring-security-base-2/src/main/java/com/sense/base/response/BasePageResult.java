package com.sense.base.response;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BasePageResult implements Serializable {
    //分页参数
    private Page page;
}
