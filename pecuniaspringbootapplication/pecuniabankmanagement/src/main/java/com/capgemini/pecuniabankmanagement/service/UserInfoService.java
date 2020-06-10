package com.capgemini.pecuniabankmanagement.service;

import com.capgemini.pecuniabankmanagement.dto.UserInfo;

public interface UserInfoService {
	public boolean register(UserInfo bean);

	public UserInfo login(String username, String password);

	public boolean updatePassword(String username, String password);
	
	public boolean deleteUser(String username);
}
