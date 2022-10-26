package com.example.javaspringboot.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T>  implements Serializable {
    private String msg;
    private Integer code;
    private T data;


    public BaseResponse(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }
}
