package com.miaoparty.rest.api.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.miaoparty.rest.api.service.response.TopicResponse;
import com.miaoparty.rest.api.service.response.TopicsResponse;

/**
 * @author Jason
 * 
 */
@Produces("application/json")
public interface TopicService {
	@GET
	@Path("/topic/{topicId}")
	public TopicResponse getTopic(@PathParam("topicId") String topicId);

	@GET
	@Path("/topics")
	public TopicsResponse getTopics();
}
