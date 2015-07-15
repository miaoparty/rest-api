package com.miaoparty.rest.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.miaoparty.rest.api.service.UserService;
import com.miaoparty.rest.api.service.dto.UserLoginRequest;
import com.miaoparty.rest.api.service.dto.UserLoginResponse;

/**
 * @author Jason
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserLoginResponse login(UserLoginRequest userLoginRequest) {
		UserLoginResponse response = new UserLoginResponse();
		if ("pethub".equals(userLoginRequest.getUsername()) && "pethub!admin".equals(userLoginRequest.getPassword())) {
			response.setToken("wGOef3eG7kjB0sd2");
			response.setMessage("Authentication Pass.");
		} else {
			response.setMessage("Invalid username or password.");
		}
		return response;
	}

	// private String generateToken() {
	//
	// }
}
