package com.miaoparty.rest.api.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.miaoparty.rest.api.service.response.LoginResponse;

/**
 * @author Jason
 * 
 */
@Produces("application/json")
public interface LoginService {
	@POST
	@Path("/login")
	public LoginResponse login(@FormParam("username") String username, @FormParam("password") String password);
}
