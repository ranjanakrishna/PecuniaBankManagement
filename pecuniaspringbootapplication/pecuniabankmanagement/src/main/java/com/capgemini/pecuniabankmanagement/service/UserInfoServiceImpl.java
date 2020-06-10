package com.capgemini.pecuniabankmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecuniabankmanagement.dao.UserInfoDao;
import com.capgemini.pecuniabankmanagement.dto.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao dao;

	@Override
	public boolean register(UserInfo bean) {
		return dao.register(bean);
	}

	@Override
	public UserInfo login(String username, String password) {
		return dao.login(username, password);
	}

	@Override
	public boolean updatePassword(String username, String password) {
		return dao.updatePassword(username, password);
	}

	@Override
	public boolean deleteUser(String username) {
		return dao.deleteUser(username);
	}

}
