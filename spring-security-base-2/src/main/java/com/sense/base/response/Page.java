package com.sense.base.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 分页信息对象
 */
@Data
@Accessors(chain = true)
public class Page implements Serializable {

    //当前页
    private Integer pageNum;
    //每页显示多少条
    private Integer pageSize;
    //总页码
    private Integer pageTotal;
    //总条数
    private Integer pageCount;
    //是否允许分页 true-可以分页 false-不能分页
    private boolean isEnable;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
