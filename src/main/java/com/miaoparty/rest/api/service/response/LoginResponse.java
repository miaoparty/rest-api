package com.miaoparty.rest.api.service.response;

/**
 * @author Jason
 *
 */
public class LoginResponse {
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
