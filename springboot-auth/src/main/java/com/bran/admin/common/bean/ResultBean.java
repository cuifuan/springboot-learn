package com.bran.admin.common.bean;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@Schema(name = "统一返回处理")
@Data
@NoArgsConstructor
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int SUCCESS = 0;
    public static final int FAIL = -1;

    private String msg = "接口返回成功";

    private int code = SUCCESS;

    private T data;

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public static <T> ResultBean<T> ok(T data) {
        return new ResultBean<>(data);
    }

    public static ResultBean<String> error(String errorMsg) {
        ResultBean<String> result = new ResultBean<>();
        result.setCode(ResultBean.FAIL);
        result.setMsg(errorMsg);
        return result;
    }

}
