package com.nhnacademy.springboot.adaptor;

import com.nhnacademy.springboot.config.AccountAdaptorProperties;
import com.nhnacademy.springboot.domain.Account;
import com.nhnacademy.springboot.domain.AccountAdaptor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AccountAdaptorImpl implements AccountAdaptor {

    private final RestTemplate restTemplate;
    private final AccountAdaptorProperties accountAdaptorProperties;

    public AccountAdaptorImpl(RestTemplate restTemplate, AccountAdaptorProperties accountAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.accountAdaptorProperties = accountAdaptorProperties;
    }

    // TODO 4 exchange method 를 이용하여 GET /accounts 를 호출하여 결과를 반환합니다. Http Status가 OK 가 아니면 RuntimeException 을 던집니다.
    @Override
    public List<Account> getAccounts() {
        return null;
    }

    // TODO 5 exchange method 를 이용하여 GET /accounts/{id} 를 호출하여 결과를 반환합니다. Http Status가 OK 가 아니면 RuntimeException 을 던집니다.

    @Override
    public Account getAccount(Long id) {
        return null;
    }

    // TODO 6 exchange method 를 이용하여 POST /accounts 를 호출하여 결과를 반환합니다. Http Status가 CREATED 가 아니면 RuntimeException 을 던집니다.
    // TODO 6 Content-Type 헤더는 application/json 으로 던져야 합니다.

    @Override
    public void createAccount(Account account) {

    }
}
