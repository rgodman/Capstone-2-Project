package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {


    List<Transfer> viewAllTransfers(Long userId);

    Transfer findTransferById(int transferId);

    List<Transfer> findTransfersByUser(Long userName);

    Transfer sendMoney();


    //do we need a sendBucks method here?  Or in the jdbc? Or in the Account controller?  All 3?
}