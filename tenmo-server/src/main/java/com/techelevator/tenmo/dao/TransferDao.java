package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {


    List<Transfer> viewAllTransfers(Long userId);

    Transfer findTransferById(int transferId);

    List<Transfer> findTransfersByUser(String userName);

    void sendBucks(Long accountFrom, Long accountTo, BigDecimal amount);





}