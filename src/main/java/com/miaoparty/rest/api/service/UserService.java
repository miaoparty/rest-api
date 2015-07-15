package com.miaoparty.rest.api.service;

import com.miaoparty.rest.api.service.dto.UserLoginRequest;
import com.miaoparty.rest.api.service.dto.UserLoginResponse;

/**
 * @author Jason
 * 
 */
public interface UserService {
	public UserLoginResponse login(UserLoginRequest userLoginRequest);
}
