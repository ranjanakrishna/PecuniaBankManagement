package com.capgemini.pecuniabankmanagement.dao;

import com.capgemini.pecuniabankmanagement.dto.UserInfo;

public interface UserInfoDao {
	public boolean register(UserInfo bean);

	public UserInfo login(String username, String password);

	public boolean updatePassword(String username, String password);

	public boolean deleteUser(String username);
}
