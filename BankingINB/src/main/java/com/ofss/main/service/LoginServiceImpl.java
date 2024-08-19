package com.ofss.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login addNewLogin(Login login) {
		return loginRepository.save(login);
	}

	@Override
	public int validateLogin(Login login) {
		Optional<Login> optionalLoginFromDB = loginRepository.findById(login.getLoginId());
		System.out.println(optionalLoginFromDB);
		if (optionalLoginFromDB.isPresent()) {
			System.out.println(optionalLoginFromDB.get());
			if (login.getLoginId() == optionalLoginFromDB.get().getLoginId()
					&& optionalLoginFromDB.get().getAttempts() < 3) {
				if (login.getPassword().equals(optionalLoginFromDB.get().getPassword())) {
					System.out.println("Login Successful");
					return 1;
				} else {
					System.out.println("Login unsuccesful, Invalid password");
					optionalLoginFromDB.get().setAttempts(optionalLoginFromDB.get().getAttempts() + 1);
					System.out.println("Attempts used:: " + optionalLoginFromDB.get().getAttempts()+1);
					return 0;
				}
			}
		} else {
			System.out.println("Account blocked as attempts over");
		}

		return 0;
	}

}
