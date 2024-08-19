package com.ofss.main.domain;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="bank_account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	@Column(name="opening_date")
	private Date openingDate;
	@Column(name="balance")
	private double balance;
	@Column(name="account_status")
    private String accountStatus;
	@Column(name="account_type")
    private String accountType;
	@Column(name = "min_balance")
	private Double minBalance;
	@Column(name="roi")
	private Double roi;
	@Column(name="max_overdraft")
	private Double max_overdraft;
	@Column(name="overdraft_bal")
	private Double overdraft_bal;
	@Transient
	private double amount;

	public Double getMax_overdraft() {
		return max_overdraft;
	}
	public void setMax_overdraft(Double max_overdraft) {
		this.max_overdraft = max_overdraft;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
    private Customer customer;
    
	public Account SavingsAccount(double currentBalance, Customer customer) {
        this.accountType = "Savings";
        this.roi = 7.0;
        this.minBalance = 1000.0;
        this.balance = currentBalance;
        this.customer = customer;
        this.overdraft_bal = 0.0;
        this.max_overdraft = 0.0;
        this.accountStatus = "ACTIVE";
        this.openingDate = Date.valueOf(LocalDate.now());
        return this;
    }
    public Account CurrentAccount(double balance,Customer customer) {
        this.accountType = "Current";
        this.roi = 0.0;
        this.minBalance = 0.0;
        this.accountStatus = "Active";
        this.max_overdraft = 50000.0;
        this.overdraft_bal = 50000.0;
        this.balance = balance;
        this.customer = customer;
        this.openingDate = Date.valueOf(LocalDate.now());
        return this;
    }
	
	
	public Double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(Double minBalance) {
		this.minBalance = minBalance;
	}

	public Double getRoi() {
		return roi;
	}

	public void setRoi(Double roi) {
		this.roi = roi;
	}

	public Double getmax_overdraft() {
		return max_overdraft;
	}

	public void setmax_overdraft(Double max_overdraft) {
		this.max_overdraft = max_overdraft;
	}

	public Double getOverdraft_bal() {
		return overdraft_bal;
	}

	public void setOverdraft_bal(Double overdraft_bal) {
		this.overdraft_bal = overdraft_bal;
	}

	public Account(int accountId, Date openingDate, double balance, String accountStatus, String accountType,
			Double minBalance, Double roi, Double max_overdraft, Double overdraft_bal, Customer customer) {
		super();
		this.accountId = accountId;
		this.openingDate = openingDate;
		this.balance = balance;
		this.accountStatus = accountStatus;
		this.accountType = accountType;
		this.minBalance = minBalance;
		this.roi = roi;
		this.max_overdraft = max_overdraft;
		this.overdraft_bal = overdraft_bal;
		this.customer = customer;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", openingDate=" + openingDate + ", balance=" + balance
				+ ", accountStatus=" + accountStatus + ", accountType=" + accountType + ", minBalance=" + minBalance
				+ ", roi=" + roi + ", max_overdraft=" + max_overdraft + ", overdraft_bal=" + overdraft_bal
				+ ", customer=" + customer + "]";
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
