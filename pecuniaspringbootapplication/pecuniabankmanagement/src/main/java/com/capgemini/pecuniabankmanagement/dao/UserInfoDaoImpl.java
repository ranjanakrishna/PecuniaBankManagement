package com.capgemini.pecuniabankmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.pecuniabankmanagement.dto.UserInfo;
import com.capgemini.pecuniabankmanagement.exception.CustomException;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	UserInfo bean = new UserInfo();

	@Override
	public boolean register(UserInfo bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
		} catch (Exception e) {
			throw new CustomException("username already exists");
		}
		entityManager.close();
		return true;
	}

	@Override
	public UserInfo login(String username, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			UserInfo bean = entityManager.find(UserInfo.class, username);
			if (bean.getPassword().equals(password)) {
				return bean;
			}
			transaction.commit();
			return null;
		} catch (Exception e) {
			throw new CustomException("account is not present");
		}
	}

	@Override
	public boolean updatePassword(String username, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			bean = entityManager.find(UserInfo.class, username);
			bean.setPassword(password);
			transaction.commit();
		} catch (Exception e) {
			throw new CustomException("Account with this username does not exists");
		}
		entityManager.close();
		return true;
	}

	@Override
	public boolean deleteUser(String username) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		UserInfo userBean = manager.find(UserInfo.class, username);
		if (userBean != null) {
			transaction.begin();
			manager.remove(userBean);
			transaction.commit();
			manager.close();
			return true;
		} else {
			throw new CustomException("Username does not exist");
		}
	}

}
