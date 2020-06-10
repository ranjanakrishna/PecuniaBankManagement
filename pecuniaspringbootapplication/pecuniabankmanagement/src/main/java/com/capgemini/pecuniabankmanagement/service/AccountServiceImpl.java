package com.capgemini.pecuniabankmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecuniabankmanagement.dao.AccountDao;
import com.capgemini.pecuniabankmanagement.dto.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao dao;

	@Override
	public boolean addAccount(Account account) {
		return dao.addAccount(account);
	}

	@Override
	public boolean updateAccount(Account account) {
		return dao.updateAccount(account);
	}

	@Override
	public boolean deleteAccount(long accountNo) {
		return dao.deleteAccount(accountNo);
	}

	@Override
	public Account searchAccount(long accountNo) {
		return dao.searchAccount(accountNo);
	}

	@Override
	public List<Account> getAccount() {
		return dao.getAccount();
	}

}
