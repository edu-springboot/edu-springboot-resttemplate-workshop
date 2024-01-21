package com.nhnacademy.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;


// TODO 2 : com.nhnacademy.account.address 키로 서버 주소를 입력할 수 있도록 수정합니다.
@ConfigurationProperties(prefix = "")
@Data
public class AccountAdaptorProperties {

    @NotNull
    private String address;
}
