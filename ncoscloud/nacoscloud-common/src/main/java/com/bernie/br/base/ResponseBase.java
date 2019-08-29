package com.bernie.br.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Bernie
 * @Date: 2019-08-17 10:34
 */
@Getter
@Setter
public class ResponseBase<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseBase(){}

    public ResponseBase(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
