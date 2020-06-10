package com.capgemini.pecuniabankmanagement.service;

import java.util.List;

import com.capgemini.pecuniabankmanagement.dto.Account;

public interface AccountService {

	public boolean addAccount(Account account);

	public boolean updateAccount(Account account);

	public boolean deleteAccount(long accountNo);

	public Account searchAccount(long accountNo);

	public List<Account> getAccount();

}
