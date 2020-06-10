package com.capgemini.pecuniabankmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.pecuniabankmanagement.dto.Account;
import com.capgemini.pecuniabankmanagement.exception.CustomException;

@Repository
public class AccountDaoImpl implements AccountDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addAccount(Account account) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(account);
			transaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			throw new CustomException("Account number already exist");
		}
	}

	@Override
	public boolean updateAccount(Account account) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Account accountBean = entityManager.find(Account.class, account.getAccountNo());
			if (account.getCustomerName() != null) {
				accountBean.setCustomerName(account.getCustomerName());
			} else {
				accountBean.setCustomerName(accountBean.getCustomerName());
			}
			if (account.getAddress() != null) {
				accountBean.setAddress(account.getAddress());
			} else {
				accountBean.setAddress(accountBean.getAddress());
			}
			if (account.getCity() != null) {
				accountBean.setCity(account.getCity());
			} else {
				accountBean.setCity(accountBean.getCity());
			}
			if (account.getState() != null) {
				accountBean.setState(account.getState());
			} else {
				accountBean.setState(accountBean.getState());
			}
			if (account.getCountry() != null) {
				accountBean.setCountry(account.getCountry());
			} else {
				accountBean.setCountry(accountBean.getCountry());
			}
			if (account.getPhoneNo() != 0) {
				accountBean.setPhoneNo(account.getPhoneNo());
			} else {
				accountBean.setPhoneNo(accountBean.getPhoneNo());
			}
			if (account.getAadhaarNo() != 0) {
				accountBean.setAadhaarNo(account.getAadhaarNo());
			} else {
				accountBean.setAadhaarNo(accountBean.getAadhaarNo());
			}
			if (account.getPanNo() != null) {
				accountBean.setPanNo(account.getPanNo());
			} else {
				accountBean.setPanNo(accountBean.getPanNo());
			}
			if (account.getDateOfBirth() != null) {
				accountBean.setDateOfBirth(account.getDateOfBirth());
			} else {
				accountBean.setDateOfBirth(accountBean.getDateOfBirth());
			}
			if (account.getGender() != null) {
				accountBean.setGender(account.getGender());
			} else {
				accountBean.setGender(accountBean.getGender());
			}
			transaction.commit();
		} catch (Exception e) {
			throw new CustomException("Account number does not exist");
		}
		entityManager.close();
		return true;
	}

	@Override
	public boolean deleteAccount(long accountNo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Account account = entityManager.find(Account.class, accountNo);
		if (account != null) {
			transaction.begin();
			entityManager.remove(account);
			transaction.commit();
			entityManager.close();
			return true;
		} else {
			throw new CustomException("Account number does not exists");
		}
	}

	@Override
	public Account searchAccount(long accountNo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Account account = entityManager.find(Account.class, accountNo);
		transaction.commit();
		if (account != null) {
			return account;
		} else {
			throw new CustomException("Account number does not exist");
		}
	}

	@Override
	public List<Account> getAccount() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Account";
		Query query = entityManager.createQuery(jpql);
		List<Account> list = query.getResultList();
		return list;
	}

}
