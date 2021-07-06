package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountDAO {

    Account getBalance(Long userId);

    void update(Account amount, Long userId) throws AccountNotFoundException;

    int getAccountId(Long userId);
    //not sure about these, but they feel ok

    List<Account> getAllAccounts(Long userId);


}
