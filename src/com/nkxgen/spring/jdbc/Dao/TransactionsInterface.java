package com.nkxgen.spring.jdbc.Dao;

import com.nkxgen.spring.jdbc.model.transactioninfo;
import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.LoanAccount;


public interface TransactionsInterface {

	public Account getAccountById(int id);

	public LoanAccount getLoanAccountById(long acnt_id);

	public void moneyDeposit(transactioninfo tempacc);

	public void loanRepayment();

	public void interestDeposit();

	public void moneyWithdrawl(transactioninfo tempacc);

	public void loanWithdrawl(long id);

}