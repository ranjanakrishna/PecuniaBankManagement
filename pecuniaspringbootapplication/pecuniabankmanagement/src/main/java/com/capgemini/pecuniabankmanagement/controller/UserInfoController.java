package com.capgemini.pecuniabankmanagement.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecuniabankmanagement.dto.Response;
import com.capgemini.pecuniabankmanagement.dto.UserInfo;
import com.capgemini.pecuniabankmanagement.service.UserInfoService;

@CrossOrigin
@RestController
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping(path = "/register-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response register(@RequestBody UserInfo bean) {
		Response response = new Response();
		if (userInfoService.register(bean)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User registered");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User already exists");
		}
		return response;
	}

	@PostMapping(path = "/login-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response login(@RequestBody UserInfo bean) {
		UserInfo userBean = userInfoService.login(bean.getUsername(), bean.getPassword());
		Response response = new Response();
		if (userBean != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Successfully logged in");
			response.setBeans(Arrays.asList(userBean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Credentials are invalid");
		}
		return response;
	}

	@PutMapping(path = "/update-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response updateUserPassword(@RequestBody UserInfo bean) {
		Response response = new Response();
		if (userInfoService.updatePassword(bean.getUsername(), bean.getPassword())) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User password updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Couldn't update user password");
		}
		return response;
	}
}

