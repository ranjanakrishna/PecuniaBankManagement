package com.capgemini.pecuniabankmanagement.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecuniabankmanagement.dto.Account;
import com.capgemini.pecuniabankmanagement.dto.Response;
import com.capgemini.pecuniabankmanagement.service.AccountService;

@CrossOrigin
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping(path = "/add-account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response addAccount(@RequestBody Account account) {
		Response response = new Response();
		if (accountService.addAccount(account)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Account created");
			response.setBeans(Arrays.asList(account));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Couldn't create account");
		}
		return response;
	}

	@PutMapping(path = "/update-account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response updateAccount(@RequestBody Account account) {
		Response response = new Response();
		if (accountService.updateAccount(account)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Account updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Account number is not present");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-account/{accountNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response deleteAccount(@PathVariable("accountNo") long accountNo) {
		Response response = new Response();
		if (accountService.deleteAccount(accountNo)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Account deleted successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Account is not deleted");
		}
		return response;
	}

	@GetMapping(path = "/search-account/{accountNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response searchAccount(@PathVariable("accountNo") long accountNo) {
		Response response = new Response();
		Account account = accountService.searchAccount(accountNo);
		if (account != null) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Account found");
			response.setBeans(Arrays.asList(account));
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Account number does not exist");
		}
		return response;
	}

	@GetMapping(path = "/get-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAccount() {
		Response response = new Response();
		List<Account> list = accountService.getAccount();
		if (list != null && !list.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Account found");
			response.setBeans(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Account not found");
		}
		return response;
	}
}
