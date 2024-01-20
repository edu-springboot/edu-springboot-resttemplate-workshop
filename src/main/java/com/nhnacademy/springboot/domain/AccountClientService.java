package com.nhnacademy.springboot.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountClientService {

    private final AccountAdaptor accountAdaptor;

    public AccountClientService(AccountAdaptor accountAdaptor) {
        this.accountAdaptor = accountAdaptor;
    }

    public List<Account> getAccounts() {
        return accountAdaptor.getAccounts();
    }
}
