package com.nhnacademy.springboot.domain;

import java.util.List;

public interface AccountAdaptor {
    List<Account> getAccounts();

    Account getAccount(Long id);

    void createAccount(Account account);
}
