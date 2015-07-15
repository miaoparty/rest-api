package com.miaoparty.rest.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miaoparty.rest.api.service.UserService;
import com.miaoparty.rest.api.service.dto.UserLoginRequest;
import com.miaoparty.rest.api.service.dto.UserLoginResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest) {
		logger.info("=============" + userLoginRequest.getUsername());
		logger.info("=============" + userLoginRequest.getPassword());
		return service.login(userLoginRequest);
	}
}
