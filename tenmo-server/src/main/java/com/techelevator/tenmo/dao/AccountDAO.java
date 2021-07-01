package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountDAO {

    Account create(Account account);

    List<Account> list();

    Account get(int id) throws AccountNotFoundException;

    void update(Account account, int id);

    void delete(int id);


}
