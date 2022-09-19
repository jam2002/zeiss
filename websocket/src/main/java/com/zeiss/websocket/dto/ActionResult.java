package com.zeiss.websocket.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class ActionResult<T> implements Serializable {
    private boolean success;
    private int code;
    private String msg;
    private T data;

    public ActionResult(boolean success, int code) {
        this.setSuccess(success);
        this.setCode(code);
    }

    public ActionResult(boolean success, int code, T data) {
        this.setSuccess(success);
        this.setCode(code);
        this.setData(data);
    }

    public ActionResult(boolean success, int code, String msg) {
        this.setSuccess(success);
        this.setCode(code);
        this.setData(this.data);
        this.setMsg(msg);
    }

    public static <T> ActionResult<T> success() {
        return new ActionResult(true, 200);
    }

    public static <T> ActionResult<T> success(T data) {
        return new ActionResult(true, 200, data);
    }
}
