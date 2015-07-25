package com.miaoparty.rest.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.miaoparty.rest.api.service.dto.UserLoginRequest;

/**
 * @author Jason
 * 
 */
@Produces("application/json")
@Consumes("application/json")
public interface UserService {
	@POST
	@Path("/login")
	public Response login(UserLoginRequest userLoginRequest);
}
