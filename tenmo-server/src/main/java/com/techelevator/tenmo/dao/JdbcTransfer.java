package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferNotFoundException;
import org.springframework.data.relational.core.sql.SQL;
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
    public List<Transfer> viewAllTransfers(Long userId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT t.*, uFrom.username AS userFrom, uTo.username AS userTo" +
                "FROM transfers t" +
                "JOIN accounts aFrom ON t.account_from = aFrom.account_id" +
                "JOIN accounts aTo ON t.account_to = aTo.account_id" +
                "JOIN users uFrom ON aFrom.user_id = uFrom.user_id" +
                "JOIN users uTo ON aTo.user_id = uTo.user_id" +
                "WHERE aFrom.user_id = ? OR aTo.user_id = ?";
        SqlRowSet transferList = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while(transferList.next()) {
            transfers.add(mapRowToTransfer(transferList));
        }
        return transfers;
    }


    @Override
    public Transfer findTransferById(int transferId) {
        Transfer transfer = new Transfer();
        String sql = "SELECT t.*, uFrom.username AS userFrom, uTo.username AS userTo, ts.transfer_status_desc, tt.transfer_type_desc" +
                "FROM transfers t " +
                "JOIN accounts aFrom ON t.account_from = aFrom.account_id" +
                "JOIN accounts aTo ON t.account_to = aTo.account_id" +
                "JOIN users uFrom ON aFrom.user_id = uFrom.user_id" +
                "JOIN users uTo ON aTo.user_id = uTo.user_id" +
                "JOIN transfer_statuses ts ON t.transfer_status_id = ts.transfer_status_id" +
                "JOIN transfer_types tt ON t.transfer_type_id = tt.transfer_type_id" +
                "WHERE t.transfer_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
        if (results.next()) {
            transfer = mapRowToTransfer(results);
        } else {
            throw new TransferNotFoundException();
        }
        return transfer;
    }


    //Errors with this one, but close
    @Override
    public List<Transfer> findTransfersByUser(String userName) {
        Transfer transfer = new Transfer();
        String sql = "SELECT t.*, uFrom.username AS userFrom, uTo.username AS userTo, ts.transfer_status_desc, tt.transfer_type_desc" +
                "FROM transfers t " +
                "JOIN accounts aFrom ON t.account_from = aFrom.account_id" +
                "JOIN accounts aTo ON t.account_to = aTo.account_id" +
                "JOIN users uFrom ON aFrom.user_id = uFrom.user_id" +
                "JOIN users uTo ON aTo.user_id = uTo.user_id" +
                "JOIN transfer_statuses ts ON t.transfer_status_id = ts.transfer_status_id" +
                "JOIN transfer_types tt ON t.transfer_type_id = tt.transfer_type_id" +
                "WHERE username = ? OR aFrom.username = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userName);
        if (results.next()) {
            transfer = mapRowToTransfer(results);
        } else {
            throw new TransferNotFoundException();
        }
        return transfer;
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