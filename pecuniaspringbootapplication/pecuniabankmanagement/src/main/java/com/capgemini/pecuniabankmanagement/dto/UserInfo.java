package com.capgemini.pecuniabankmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="userinfo")
public class UserInfo {
	@Id
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String userType;
}
