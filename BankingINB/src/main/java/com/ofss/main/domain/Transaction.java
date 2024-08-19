package com.ofss.main.domain;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	 	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "transaction_id")
	    private int transactionId;
		@Column(name = "transaction_time")
	    private Timestamp transactionTime;
		@Column(name = "type")
	    private String type;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "account_id")
	    private Account account;
		
		@Column(name = "recepient_acc_id")
	    private int recepientAccId;
		@Column(name = "transaction_status")
	    private String transactionStatus;
		@Column(name = "amount")
	    private double amount;
		public Transaction() {
			super();
		}
		public Transaction(Timestamp transactionTime, int transactionId, String type, Account account,
				int recepientAccId, String transactionStatus, double amount) {
			super();
			this.transactionTime = transactionTime;
			this.transactionId = transactionId;
			this.type = type;
			this.account = account;
			this.recepientAccId = recepientAccId;
			this.transactionStatus = transactionStatus;
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "Transaction [transactionTime=" + transactionTime + ", transactionId=" + transactionId + ", type="
					+ type + ", account=" + account + ", recepientAccId=" + recepientAccId + ", transactionStatus="
					+ transactionStatus + ", amount=" + amount + "]";
		}
		public Timestamp getTransactionTime() {
			return transactionTime;
		}
		public void setTransactionTime(Timestamp transactionTime) {
			this.transactionTime = transactionTime;
		}
		public int getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		public int getRecepientAccId() {
			return recepientAccId;
		}
		public void setRecepientAccId(int recepientAccId) {
			this.recepientAccId = recepientAccId;
		}
		public String getTransactionStatus() {
			return transactionStatus;
		}
		public void setTransactionStatus(String transactionStatus) {
			this.transactionStatus = transactionStatus;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
}
