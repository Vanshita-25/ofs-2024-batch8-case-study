package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
@Service
public interface AccountService {
	Account createNewSavingsAccount (Account account);
	Account createNewCurrentAccount(Account account);
    Account getAccountsbyCustomerId(int customerId);
    Account getBalances(int account_id);
    boolean withdrawMoney(int accountId, double amount);
    boolean depositMoney(int accountId, double amount);
}
