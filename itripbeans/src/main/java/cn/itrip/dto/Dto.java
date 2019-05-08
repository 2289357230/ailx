package cn.itrip.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  响应给前端的数据格式
 *
 * @param <T>
 */
@ApiModel(value="响应给前端传输对象",description="这是一个数据传输对象，响应给前端")
public class Dto<T> {
     @ApiModelProperty(notes = "错误编号")
     private String errorCode;
     private String success;
    @ApiModelProperty(notes = "操作消息")
     private String msg;
     private T data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
