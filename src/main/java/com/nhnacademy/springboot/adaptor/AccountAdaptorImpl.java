package com.nhnacademy.springboot.adaptor;

import com.nhnacademy.springboot.config.AccountAdaptorProperties;
import com.nhnacademy.springboot.domain.Account;
import com.nhnacademy.springboot.domain.AccountAdaptor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class AccountAdaptorImpl implements AccountAdaptor {

    private final WebClient webClient;
    private final AccountAdaptorProperties accountAdaptorProperties;

    public AccountAdaptorImpl(WebClient webClient, AccountAdaptorProperties accountAdaptorProperties) {
        this.webClient = webClient;
        this.accountAdaptorProperties = accountAdaptorProperties;
    }

    @Override
    public List<Account> getAccounts() {
        return webClient.get()
                .uri(accountAdaptorProperties.getAddress()+"/accounts")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Account>>() {})
                .block();

    }

    @Override
    public Account getAccount(Long id) {
        return webClient.get()
                .uri(accountAdaptorProperties.getAddress()+"/accounts/{accountId}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Account>() {})
                .block();
    }

    @Override
    public void createAccount(Account account) {
        webClient.post()
                .uri(accountAdaptorProperties.getAddress()+"/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(account)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
