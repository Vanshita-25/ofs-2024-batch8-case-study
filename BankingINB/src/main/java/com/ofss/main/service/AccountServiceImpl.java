package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.repository.AccountRepository;
import com.ofss.main.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Account getAccountsbyCustomerId(int customerId) {
		Optional<Account> accounts = accountRepository.findById(customerId);
		return accounts.get();
	}


	@Override
	public Account createNewSavingsAccount(Account account) {
		Optional<Customer> optionalCustomer = customerRepository.findById(account.getCustomer().getCustomerId());
		Customer customer = optionalCustomer.get();
		account.setCustomer(customer);
		return accountRepository.save(account);
	}


	@Override
	public Account createNewCurrentAccount(Account account) {
		Optional<Customer> optionalCustomer = customerRepository.findById(account.getCustomer().getCustomerId());
		Customer customer = optionalCustomer.get();
		account.setCustomer(customer);
		return accountRepository.save(account);
	}


	@Override
	public Account getBalances(int account_id) {
		Optional<Account> account = accountRepository.findById(account_id);
		if(account.isPresent()) {
			return account.get();
		}
		return null;
	}


	@Override
	public boolean withdrawMoney(int accountId, double amount) {
		Account accountFromDb;
		Optional<Account> account = accountRepository.findById(accountId);
		if(account.isPresent()) {
			accountFromDb = account.get();
			if(accountFromDb.getAccountType().equals("Savings")) {
				if(amount > accountFromDb.getBalance()-accountFromDb.getMinBalance()) {
					accountFromDb.setBalance(accountFromDb.getBalance()-amount);
					accountRepository.save(accountFromDb);
				}
			}
			else if (accountFromDb.getAccountType().equals("Current")) {
				if(amount < accountFromDb.getOverdraft_bal()+accountFromDb.getBalance()) {
					if(amount>accountFromDb.getBalance()) {
						accountFromDb.setOverdraft_bal(accountFromDb.getOverdraft_bal()-(amount-accountFromDb.getBalance()));
	                    accountFromDb.setBalance(0);
	                    accountRepository.save(accountFromDb);
	                    return true;
					}
					
					 else{
						 accountFromDb.setBalance(accountFromDb.getBalance()-amount);
		                    accountRepository.save(accountFromDb);
		                    return true;
		                }
				}
				return false;
				
			}
		}
		return false;
	}


	@Override
	public boolean depositMoney(int accountId, double amount) {
		// TODO Auto-generated method stub
		return false;
	}



}
