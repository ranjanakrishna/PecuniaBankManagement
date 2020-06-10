package com.capgemini.pecuniabankmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(nullable = false)
	private Long accountNo;
	@Column
	private String customerName;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private long phoneNo;
	@Column
	private long aadhaarNo;
	@Column
	private String panNo;
	@Column
	private String dateOfBirth;
	@Column
	private String gender;
}