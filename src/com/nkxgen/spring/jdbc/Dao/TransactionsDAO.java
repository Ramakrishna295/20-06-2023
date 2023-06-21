package com.nkxgen.spring.jdbc.Dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nkxgen.spring.jdbc.model.TempAccounts;
import com.nkxgen.spring.jdbc.model.transactioninfo;
import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.LoanAccount;

@Repository
@Transactional
public class TransactionsDAO implements TransactionsInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void moneyDeposit(transactioninfo trans) {
		System.out.println("got into the moneydeposit function");
		Account account = entityManager.find(Account.class, (long)trans.getAccountNumber());
		long balance = (long) (account.getBalance() + (long)trans.getAmount());
		account.setBalance(balance);
	}

	@Override
	public void moneyWithdrawl(transactioninfo trans) {
		Account account = entityManager.find(Account.class, (long)trans.getAccountNumber());
		if (account.getBalance() >= trans.getAmount()) {
			int balance = (int) (account.getBalance() - trans.getAmount());
			account.setBalance(balance);
		} else {
			System.out.println("no sufficient balance");
		}
	}

	@Override
	public void loanRepayment() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interestDeposit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loanWithdrawl(long id) {
		LoanAccount account = entityManager.find(LoanAccount.class, id);
		System.out.println("the value of loan amount in tdao is" + account.getLoanAmount());
		account.setdeductionAmt(account.getLoanAmount());
	}

	public Account getAccountById(int id) {
		long ids=(long)id;
		System.out.println("trasnactions loki vachanu");
		Account account = entityManager.find(Account.class, ids);
		return account;

	}

	public LoanAccount getLoanAccountById(long id) {
		LoanAccount account = entityManager.find(LoanAccount.class, id);
		return account;

	}

}