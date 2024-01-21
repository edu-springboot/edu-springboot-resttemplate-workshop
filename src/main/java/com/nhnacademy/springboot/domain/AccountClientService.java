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

    public Account getAccount(Long id) {
        return accountAdaptor.getAccount(id);
    }

    public void createAccount(Account account) {
        accountAdaptor.createAccount(account);
    }
}
