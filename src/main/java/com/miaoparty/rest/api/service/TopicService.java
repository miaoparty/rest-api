package com.miaoparty.rest.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author Jason
 * 
 */
@Produces("application/json")
@Consumes("application/json")
public interface TopicService {

	@GET
	@Path("/{topicId}")
	public Response getTopic(@PathParam("topicId") int topicId);

	@GET
	@Path("/getTopics")
	public Response getTopics();
}
