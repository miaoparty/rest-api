package com.miaoparty.rest.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.miaoparty.rest.api.service.LoginService;
import com.miaoparty.rest.api.service.response.LoginResponse;

/**
 * @author Jason
 * 
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Override
	public LoginResponse login(String username, String password) {
		LoginResponse response = new LoginResponse();
		logger.info("username=" + username);
		logger.info("password=" + password);
		if ("pethub".equals(username) && "pethub!admin".equals(password)) {
			response.setToken("wGOef3eG7kjB0sd2");
			response.setMessage("Authentication Pass.");
		} else {
			response.setMessage("Invalid username or password.");
		}
		return response;
	}
	
//	private String generateToken() {
//		
//	}
}
