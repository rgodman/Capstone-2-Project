package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class JdbcAccountDao implements AccountDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getBalance(Long userId) {
        Account account = new Account();
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if(results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public void update(Account amount, Long userId) {
        //I know we need more
    }

    @Override
    public int getAccountId(Long userId) {
        return 0;
    }
//need more

    private Account mapRowToAccount(SqlRowSet rowSet) {
        Account account = new Account();
        account.setAccountId(rowSet.getLong("account_id"));
        account.setUserID(rowSet.getLong("user_id"));
        account.setBalance(rowSet.getBigDecimal("balance"));
        
        return account;
    }


}
