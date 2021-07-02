package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransfer implements TransferDao{

    private JdbcTemplate jdbcTemplate;

    public  JdbcTransfer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //need to figure out sql statement to grab these properly
    @Override
    public List<Transfer> viewTransfers(Long userId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "";
        SqlRowSet transferList = jdbcTemplate.queryForRowSet(sql, userId);
        while(transferList.next()) {
            transfers.add(mapRowToTransfer(transferList));
        }
        return transfers;
    }


    @Override
    public Transfer findByTransferId(Long transferId) {
        return null;
    }

    @Override
    public List<Transfer> findTransfersByUser(Long userName) {
        return null;
    }

    @Override
    public Transfer sendMoney() {
        return null;
    }

    private Transfer mapRowToTransfer(SqlRowSet rowSet) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rowSet.getLong("transfer_id"));
        transfer.setTransferTypeId(rowSet.getLong("transfer_type_id"));
        transfer.setTransferStatusId(rowSet.getLong("transfer_status_id"));
        transfer.setAccountFromId(rowSet.getLong("account_from"));
        transfer.setAccountToId(rowSet.getLong("account_to"));
        transfer.setAmount(rowSet.getBigDecimal("amount"));
        transfer.setTransferTypeDesc(rowSet.getString("transfer_type_desc"));
        transfer.setTransferStatusDesc(rowSet.getString("transfer_status_desc"));

        return transfer;
    }
}
