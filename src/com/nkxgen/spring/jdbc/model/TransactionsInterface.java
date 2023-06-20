package com.nkxgen.spring.jdbc.model;

public interface TransactionsInterface {

	public TempAccounts getAccountById(int id);

	public LoanAccount getLoanAccountById(long acnt_id);

	public void moneyDeposit(transactioninfo tempacc);

	public void loanRepayment();

	public void interestDeposit();

	public void moneyWithdrawl(transactioninfo tempacc);

	public void loanWithdrawl(long id);

}