package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AccountsTable")
public class Account {
	@Id
	@Column(name = "account_id")
	private Long accountId;

	@Column(name = "account_type_id")
	private String accountTypeId;

	@Column(name = "nominee_first_name")
	private String applicationNomineeFirstName;

	@Column(name = "nominee_last_name")
	private String applicationNomineeLastName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acap_cust_id", referencedColumnName = "cust_id")
	private Customertrail customer;

	@Column(name = "Created_date")
	private String CreatedDate;

	@Column(name = "balance")
	private long balance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acap_createdby", referencedColumnName = "busr_id")
	private BankUser createdByUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acap_processedby", referencedColumnName = "busr_id")
	private BankUser processedByUser;
	// Getters and setters

	
	public long getAccount_id() {
		return accountId;
	}
	public Long getApplicationId() {
		return accountId;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public String getApplicationNomineeFirstName() {
		return applicationNomineeFirstName;
	}

	public String getApplicationNomineeLastName() {
		return applicationNomineeLastName;
	}

	public Customertrail getCustomer() {
		return customer;
	}

	public void setCustomer(Customertrail customer) {
		this.customer = customer;
	}

	public String getCreated_date() {
		return CreatedDate;
	}

	public BankUser getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(BankUser createdByUser) {
		this.createdByUser = createdByUser;
	}

	public BankUser getProcessedByUser() {
		return processedByUser;
	}

	public void setProcessedByUser(BankUser processedByUser) {
		this.processedByUser = processedByUser;
	}

	public void setApplicationId(Long accountId) {
		this.accountId = accountId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public void setApplicationNomineeFirstName(String applicationNomineeFirstName) {
		this.applicationNomineeFirstName = applicationNomineeFirstName;
	}

	public void setApplicationNomineeLastName(String applicationNomineeLastName) {
		this.applicationNomineeLastName = applicationNomineeLastName;
	}

	public void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance_amt) {
		this.balance = balance_amt;
	}

	public void setInputModelValues(AccountInput input) {
		Customertrail c = new Customertrail();
		c.setId(input.getCustomerId());
		this.accountId = input.getApplicationId();
		this.accountTypeId = input.getAccountTypeId();
		this.applicationNomineeFirstName = input.getApplicationNomineeFirstName();
		this.applicationNomineeLastName = input.getApplicationNomineeLastName();
		this.customer = c;
		BankUser b = new BankUser();
		b.setBusr_id(input.getCreatedBy());
		b.setBusr_id(input.getProcessedBy());
		this.CreatedDate = input.getCreated_date();
		this.createdByUser = b;
		this.processedByUser = b;
		this.balance = input.getBalance();
	}

}
