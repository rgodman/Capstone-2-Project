package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {
    private AccountDAO accountDAO;

    public AccountController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @RequestMapping(path = "balance/{id}", method = RequestMethod.GET)
    public Account getBalance(@Valid @PathVariable Long id) {
        return accountDAO.getBalance(id);
    }


    @RequestMapping(path = "balance/{id}", method = RequestMethod.PUT)
    public Account update(@Valid @PathVariable Long id) {
        return accountDAO.getBalance(id);
    }
}
