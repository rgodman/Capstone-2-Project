package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {


    List<Transfer> findAll();

    Transfer update(Long transferId);

    Transfer findByTransferId(Long transferId);

    List<Transfer> findTransfersByUser(Long userName);
}
