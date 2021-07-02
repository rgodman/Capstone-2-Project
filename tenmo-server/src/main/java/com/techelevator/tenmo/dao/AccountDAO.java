package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountDAO {

    Account getBalance(Long userId);




}
