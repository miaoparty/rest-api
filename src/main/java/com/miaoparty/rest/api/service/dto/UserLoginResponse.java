package com.miaoparty.rest.api.service.dto;

/**
 * @author Jason
 *
 */
public class UserLoginResponse {
	private String token;
	private String message;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoginResponse{" + "token='" + token + '\'' + ", message=" + message + '}';
	}
}
