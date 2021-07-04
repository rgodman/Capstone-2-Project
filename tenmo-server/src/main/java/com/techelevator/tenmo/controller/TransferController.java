package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class TransferController {

    private UserDao userDao;
    private TransferDao transferDao;
//    private final TokenProvider tokenProvider;

    public TransferController(UserDao userDao, TransferDao transferDao) {
        this.userDao = userDao;
        this.transferDao = transferDao;
    }


    @RequestMapping(path = "transfers", method = RequestMethod.GET)
    public List<Transfer> findTransfersByUser(@PathVariable String userName) {
        return transferDao.findTransfersByUser(userName);
    }

    @RequestMapping(path = "transfers", method = RequestMethod.GET)
    public List<Transfer> viewAllTransfers(@PathVariable Long userId) {
        return transferDao.viewAllTransfers(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public void sendBucks(@RequestParam Long accountFrom, @RequestParam Long accountTo, @RequestParam BigDecimal amount) {
        transferDao.sendBucks(accountTo, accountFrom, amount);
    }
}