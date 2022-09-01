package com.zhc.springlearn;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.MDC;

import static com.zhc.springlearn.traceid.TraceIdFilter.TRACE_ID;

@Data
@AllArgsConstructor
public class RetResult<T> {

    private Integer code;

    private String msg;

    private T data;

    private String traceId;

    public RetResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.traceId = MDC.get(TRACE_ID);
    }

    public static <T> RetResult<T> success(T t) {
        return new RetResult<>(0000, "ok", t);
    }

    public static <T> RetResult<T> success() {
        return new RetResult<>(0001, "ok", null);
    }

    public static <T> RetResult<T> fail() {
        return new RetResult<>(0001, "fail", null);
    }

    public static <T> RetResult<T> fail(String msg) {
        return new RetResult<>(0001, msg, null);
    }

    public static <T> RetResult<T> fail(Integer code, String msg) {
        return new RetResult<>(code, msg, null);
    }
}
