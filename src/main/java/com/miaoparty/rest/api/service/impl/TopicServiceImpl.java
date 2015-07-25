package com.miaoparty.rest.api.service.impl;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaoparty.rest.api.biz.TopicBiz;
import com.miaoparty.rest.api.entity.Topic;
import com.miaoparty.rest.api.service.TopicService;
import com.miaoparty.rest.api.service.dto.TopicResponse;

/**
 * @author Jason
 * 
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
	static final Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);

	@Autowired
	TopicBiz topicBiz;

	@Override
	public Response getTopic(int topicId) {
		logger.info("topicId=" + topicId);
		Topic topic = topicBiz.getTopic(topicId);
		TopicResponse response = new TopicResponse();
		response.setAuthor(topic.getAuthor());
		response.setCategoryId(topic.getCategoryId());
		response.setContent(topic.getContent());
		response.setDate(topic.getDate());
		response.setId(topic.getId());
		response.setReference(topic.getReference());
		response.setTitle(topic.getTitle());
		return Response.ok(response).build();
	}

	@Override
	public Response getTopics() {
		// TODO Auto-generated method stub
		return null;
	}
}
