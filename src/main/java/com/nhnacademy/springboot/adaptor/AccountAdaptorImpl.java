package com.nhnacademy.springboot.adaptor;

import com.nhnacademy.springboot.domain.Account;
import com.nhnacademy.springboot.domain.AccountAdaptor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AccountAdaptorImpl implements AccountAdaptor {

    private final RestTemplate restTemplate;

    public AccountAdaptorImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Account> getAccounts() {
        ResponseEntity<List<Account>> responseEntity = restTemplate.exchange("http://localhost:8080/accounts", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        if ( responseEntity.getStatusCode() != HttpStatus.OK ) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }
}
