package com.ofss.main.service;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;

public interface LoginService {
	Login addNewLogin(Login login);

	int validateLogin(Login Login);

}
