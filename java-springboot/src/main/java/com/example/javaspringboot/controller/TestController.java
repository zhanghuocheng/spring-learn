package com.example.javaspringboot.controller;

import com.example.javaspringboot.Model.BaseResponse;
import com.example.javaspringboot.Model.DoPostRequest;
import com.example.javaspringboot.Model.DoPostResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("/get")
    public BaseResponse test() {
        return new BaseResponse();
    }


    @PostMapping("doPost")
    public DoPostResponse doPost(@RequestBody DoPostRequest doPostRequest) {
        return DoPostResponse.builder().build();
    }

    @PostMapping("doError")
    public DoPostResponse doError(@RequestBody DoPostRequest doPostRequest) {
        throw new IllegalArgumentException();
    }
}
