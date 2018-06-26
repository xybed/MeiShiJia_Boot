package com.qiqi.meishijia.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultEnum.SUCCESS.getCode())
                .setMessage(ResultEnum.SUCCESS.getMsg());
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultEnum.SUCCESS.getCode())
                .setMessage(ResultEnum.SUCCESS.getMsg())
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultEnum.FAIL.getCode())
                .setMessage(message);
    }

    public static Result genFailResult(ResultEnum resultEnum){
        return new Result()
                .setCode(resultEnum.getCode())
                .setMessage(resultEnum.getMsg());
    }
}
