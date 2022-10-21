package com.example.javaspringboot.controller;

import com.example.javaspringboot.Model.DoPostRequest;
import com.example.javaspringboot.Model.DoPostResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("/get")
    public String test() {
        return "helloworld";
    }


    @PostMapping("doPost")
    public DoPostResponse doPost(@RequestBody DoPostRequest doPostRequest) {
        return DoPostResponse.builder().build();
    }
}
