package com.nhnacademy.springboot.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
    private Long id;
    private String number;
    private Integer balance;
}
