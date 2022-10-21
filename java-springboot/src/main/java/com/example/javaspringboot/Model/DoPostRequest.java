package com.example.javaspringboot.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoPostRequest {
    private String myName;
    private int myAge;
    private String myAddress;
}
