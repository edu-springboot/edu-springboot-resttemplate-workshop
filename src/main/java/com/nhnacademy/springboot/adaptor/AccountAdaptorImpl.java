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

    @Override
    public List<Account> getAccounts() {
        ResponseEntity<List<Account>> responseEntity = restTemplate.exchange(accountAdaptorProperties.getAddress()+"/accounts", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        if ( responseEntity.getStatusCode() != HttpStatus.OK ) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }

    @Override
    public Account getAccount(Long id) {
        ResponseEntity<Account> responseEntity = restTemplate.exchange(accountAdaptorProperties.getAddress()+"/accounts/{accountId}", HttpMethod.GET, null, new ParameterizedTypeReference<>() {}, id);
        if ( responseEntity.getStatusCode() != HttpStatus.OK ) {
            throw new RuntimeException();
        }
        return responseEntity.getBody();
    }

    @Override
    public void createAccount(Account account) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Account> request = new HttpEntity<>(account, headers);
        ResponseEntity<Void> responseEntity = restTemplate.exchange(accountAdaptorProperties.getAddress()+"/accounts", HttpMethod.POST, request, new ParameterizedTypeReference<>() {});
        if ( responseEntity.getStatusCode() != HttpStatus.CREATED ) {
            throw new RuntimeException();
        }
    }
}
