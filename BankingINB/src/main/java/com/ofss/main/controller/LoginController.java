package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.service.LoginService;

@RequestMapping("loginbanking")
@RestController
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//http://localhost:8080/loginbanking
	@PostMapping("login")
	public Login addNewLogin(@RequestBody Login login) {
		return loginService.addNewLogin(login);
	}
	
	@PostMapping("logins")
	public int validateLogin(@RequestBody Login login) {
		return loginService.validateLogin(login);
	}
}
