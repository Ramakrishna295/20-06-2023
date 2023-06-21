package com.nkxgen.spring.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.TempAccounts;
import com.nkxgen.spring.jdbc.Dao.TransactionsInterface;
import com.nkxgen.spring.jdbc.model.transactioninfo;;

@Controller
public class TransactionController {

	@Autowired
	TransactionsInterface ti;

	@RequestMapping(value = "/moneydeposit", method = RequestMethod.GET)
	public String money(Model model) {
		return "Money_Deposit";
	}

	@RequestMapping(value = "/loanrepay", method = RequestMethod.GET)
	public String loan(Model model) {
		return "Loan_Repayment";
	}

	@RequestMapping(value = "/interest", method = RequestMethod.GET)
	public String interest(Model model) {
		return "Interest_Deposit";
	}

	@RequestMapping(value = "/withdrawl", method = RequestMethod.GET)
	public String moneywid(Model model) {
		return "money_withdrawl_form";
	}

	@RequestMapping(value = "/lowid", method = RequestMethod.GET)
	public String lowid(Model model) {
		return "loan_withdrawl_form";
	}

	// money_deposit
	@RequestMapping(value = "/getaccountdetails", method = RequestMethod.POST)
	public String getaccountdetails(@RequestParam("accountNumber") int Acnt_id, Model model) {
		int acnt_id = Acnt_id;
		System.out.println("print the value: " + acnt_id);
		Account account = ti.getAccountById(acnt_id);
		System.out.println("print the value vachindhi raa: " + account.getAccount_id());
		model.addAttribute("account", account);
		return "sub_money_deposit";
	}

	// sub_money_deposit
	@RequestMapping(value = "/moneyDepositurl")
	public String getDepositMoney(@Validated transactioninfo tarn, Model model) {
		System.out.println("deposit completed");
		int acnt_id = tarn.getAccountNumber();
		// int amount = (int) tarn.getAmount();
		System.out.println("the value of account is" + acnt_id);
		ti.moneyDeposit(tarn);
		System.out.println("--------------------------------------------------");
		return "Money_Deposit";
	}

	// =====================================================================================================================

	// loan_repayment
	@RequestMapping(value = "/getloanrepaytdetails", method = RequestMethod.POST)
	public String getloanrepaytdetails(@RequestParam("accountNumber") long loan_id, Model model) {
		long loan_Id = loan_id;
		LoanAccount account = ti.getLoanAccountById(loan_Id);
		model.addAttribute("account", account);
		return "sub_loan_repayment.html";
	}

	// =====================================================================================================================
	// money_withdrawl
	@RequestMapping(value = "/getaccountdetailsmoneyWithdrawl", method = RequestMethod.POST)
	public String getaccountdetailsmoneyWithdrawl(@RequestParam("accountNumber") int Acnt_id, Model model) {
		int acnt_id = Acnt_id;
		System.out.println("print the value: " + acnt_id);
		Account account = ti.getAccountById(acnt_id);
	//	System.out.println("print the value vachindhi raa: " + account.getAcnt_cust_id());
		model.addAttribute("account", account);
		return "sub_money_withdrawl";
	}

	// sub_money_withdrawl
	@RequestMapping(value = "/moneywithdrawlurl")
	public String getmoneywithdrawl(@Validated transactioninfo tarn, Model model) {
		System.out.println("deposit completed");
		int acnt_id = tarn.getAccountNumber();

		System.out.println("the value of account is" + acnt_id);
		ti.moneyWithdrawl(tarn);
		System.out.println("--------------------------------------------------");
		return "money_withdrawl_form";
	}

	// =====================================================================================================================

	// loan_withdrawl
	@RequestMapping(value = "/getloandetails", method = RequestMethod.POST)
	public String getloandetails(@RequestParam("accountNumber") long loan_id, Model model) {
		long acnt_id = loan_id;
		LoanAccount account = ti.getLoanAccountById(acnt_id);
		model.addAttribute("account", account);
		System.out.println("the loan amount is" + account.getLoanAmount());
		return "sub_loan_withdrawl";
	}

	// sub_loan_withdrawl
	@RequestMapping(value = "/loanwithdrawlurl", method = RequestMethod.POST)
	public String getloanmoneywithdrawl(@RequestParam("accountNumber") long loan_id, Model model) {
		System.out.println("the loan account id is " + loan_id);
		long loan_Id = loan_id;
		ti.loanWithdrawl(loan_Id);
		return "loan_withdrawl_form";
	}

}