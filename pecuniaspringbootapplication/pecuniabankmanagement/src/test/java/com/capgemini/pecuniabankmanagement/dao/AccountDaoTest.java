package com.capgemini.pecuniabankmanagement.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.capgemini.pecuniabankmanagement.dto.Account;
import com.capgemini.pecuniabankmanagement.exception.CustomException;

@SpringBootTest
public class AccountDaoTest {

	private Account account = new Account();

	@Autowired
	private AccountDao accountDao;

	@Test
	public void addAccount() {
		account.setAccountNo(85445252255l);
		account.setCustomerName("ranjana");
		account.setAddress("mys");
		account.setCity("mys");
		account.setState("k");
		account.setCountry("Ind");
		account.setPhoneNo(8544555244l);
		account.setAadhaarNo(5555558888888l);
		account.setPanNo("gfddd555d");
		account.setDateOfBirth("ddffddf");
		account.setGender("F");
		try {
			boolean flag = accountDao.addAccount(account);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(CustomException.class, () -> {
				accountDao.addAccount(account);
			});
		}
	}

//	@Test
//	public void deleteAccount() {
//		try {
//			boolean flag = accountDao.deleteAccount(account.getAccountNo());
//			assertEquals(flag, true);
//		} catch (Exception e) {
//			assertThrows(CustomException.class, () -> {
//				accountDao.deleteAccount(account.getAccountNo());
//			});
//		}
//	}

	@Test
	public void getAccount() {
		assertNotNull(accountDao.getAccount());
	}

	@Test
	void searchAccount() {
		long accountNo = 85445252255l;
		try {
			Account account = accountDao.searchAccount(accountNo);
			assertEquals(account != null, true);
		} catch (Exception e) {
			assertThrows(CustomException.class, () -> {
				accountDao.searchAccount(accountNo);
			});
		}
	}

	@Test
	public void updateAccount() {
		Account account = new Account();
		account.setAccountNo(85445252255l);
		account.setCustomerName("ranjanak");
		account.setAddress("mysore");
		account.setCity("mysore");
		account.setState("karnataka");
		account.setCountry("India");
		account.setPhoneNo(8544555248l);
		account.setAadhaarNo(5555558888877l);
		account.setPanNo("gfddd777d");
		account.setDateOfBirth("ddffdmm");
		account.setGender("Female");
		try {
			boolean flag = accountDao.updateAccount(account);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(CustomException.class, () -> {
				accountDao.updateAccount(account);
			});
		}
	}
}
