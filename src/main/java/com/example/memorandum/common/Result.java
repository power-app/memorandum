package com.example.memorandum.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yeah
 * @create 2022/9/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    // 状态码
    private Integer code;
    // 提示消息
    private String msg;
    // 数据
    private Object data;

    /**
     * 成功的返回
     *
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    /**
     * 成功的返回
     *
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    /**
     * 失败的返回
     *
     * @return
     */
    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        result.setMsg("失败");
        return result;
    }

    /**
     * 返回错误信息
     * @param message
     * @return
     */
    public static Result error(String message) {
        Result result = new Result();
        result.setCode(500);
        result.setMsg(message);
        return result;
    }

    public static Result toResult(boolean success) {
        return success ? Result.success() : Result.error();
    }
}
