package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.service.AccountService;

@RestController
@CrossOrigin("*")
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("accounts/{customerId}")
	public ResponseEntity<Account> getAllAccounts(@PathVariable int customerId){
		Account account= accountService.getAccountsbyCustomerId(customerId);
		return new ResponseEntity<>(account,null,200);
	}
	
	  @PostMapping("savings")
	    public Account createSavingsAccount(@RequestBody Account account) {
	        Account newAccount = new Account();
	        newAccount.SavingsAccount(account.getBalance(), account.getCustomer());
	        return accountService.createNewSavingsAccount(newAccount);
	    }

	    @PostMapping("current")
	    public Account createCurrentAccount(@RequestBody Account account) {
	        Account newAccount = new Account();
	        newAccount.CurrentAccount(account.getBalance(),account.getCustomer());
	        return accountService.createNewCurrentAccount(newAccount);
	    }
	    

	    @PostMapping("withdraw")
	    public boolean withdrawFromAccount(@RequestBody Account account) {
	        boolean status = accountService.withdrawMoney(account.getAccountId(),account.getAmount());
	        if(status){
	            //transactionService.registerTransaction(account.getAmount(), account.getAccountId(), account.getAccountId(), "Withdrawal");
	            return true;
	        }else{
	            return false;
	        }
	    }
}
