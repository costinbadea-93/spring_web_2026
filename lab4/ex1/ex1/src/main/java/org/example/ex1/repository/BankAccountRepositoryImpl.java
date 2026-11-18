package org.example.ex1.repository;

import lombok.RequiredArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BankAccountRepositoryImpl implements BankAccountRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public BankAccount addNewBankAccount(BankAccount bankAccount) {
        String sql = "INSERT INTO BANK_ACCOUNT (id, account_number, account_owner_name, account_balance) VALUES (NULL, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            // Specifying new String[]{"id"} ensures only the primary key is returned across all DBs (H2, Postgres, MySQL)
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, bankAccount.getAccountNumber());
            ps.setString(2, bankAccount.getAccountOwnerName());
            ps.setDouble(3, bankAccount.getAccountBalance());
            return ps;
        }, keyHolder);

        // Extract the generated key
        Number generatedId = keyHolder.getKey();
        bankAccount.setId(generatedId.intValue());
        return  bankAccount;


    }

    @Override
    public List<BankAccount> retrieveAllAccounts() {
        String sql = "SELECT * FROM bank_account";
        return jdbcTemplate.query(sql,(rs, rowNum) -> {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(rs.getInt("id"));
            bankAccount.setAccountNumber(rs.getString("account_number"));
            bankAccount.setAccountOwnerName(rs.getString("account_owner_name"));
            bankAccount.setAccountBalance(rs.getDouble("account_balance"));
            return bankAccount;
        });
    }

    @Override
    public BankAccount findByAccountNumber(String accountNumber) {
        String sql = "SELECT id, account_number, account_owner_name, account_balance FROM BANK_ACCOUNT WHERE account_number = ?";

        RowMapper<BankAccount> bankAccountRowMapper = (rs, rowNum) -> new BankAccount(
                rs.getInt("id"),
                rs.getString("account_number"),
                rs.getString("account_owner_name"),
                rs.getDouble("account_balance")
        );

        return jdbcTemplate.queryForObject(sql, bankAccountRowMapper, accountNumber);
    }

    @Override
    public int updateBalance(String accountNumber, double newBalance) {
        String sql = "UPDATE BANK_ACCOUNT SET account_balance = ? WHERE account_number = ?";
        return jdbcTemplate.update(sql, newBalance, accountNumber); // Returns number of rows updated (1 if found, 0 if not)

    }
}
