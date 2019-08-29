package com.bernie.br.base;


import com.bernie.br.utils.Constant;

/**
 * @Author: Bernie
 * @Date: 2019-08-17 10:41
 */
public class BaseApiResponse<T> {

    public ResponseBase setSuccessResult(){
        return new ResponseBase<T>(Constant.HTTP_RES_CODE_200,Constant.HTTP_RES_CODE_200_VALUE,null);
    }

    public ResponseBase setSuccessResult(String msg){
        return new ResponseBase<T>(Constant.HTTP_RES_CODE_200,msg,null);
    }

    public ResponseBase setSuccessResult(T data){
        return new ResponseBase<T>(Constant.HTTP_RES_CODE_200,Constant.HTTP_RES_CODE_200_VALUE,data);
    }

    public ResponseBase setSuccessResult(String msg,T data){
        return new ResponseBase<T>(Constant.HTTP_RES_CODE_200,msg,data);
    }

    public ResponseBase setFailedResult(){
        return new ResponseBase<T>(Constant.HTTP_RES_CODE_500,Constant.HTTP_RES_CODE_500_VALUE,null);
    }

    public ResponseBase setFailedResult(String msg){
        return new ResponseBase<T>(Constant.HTTP_RES_CODE_500,msg,null);
    }

    public ResponseBase setResult(Integer code,String msg,T data){
        return new ResponseBase<T>(code,msg,data);
    }

}
