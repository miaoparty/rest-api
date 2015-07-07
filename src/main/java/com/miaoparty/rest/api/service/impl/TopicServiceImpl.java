package com.miaoparty.rest.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaoparty.rest.api.biz.TopicBiz;
import com.miaoparty.rest.api.entity.Topic;
import com.miaoparty.rest.api.service.TopicService;
import com.miaoparty.rest.api.service.response.TopicResponse;
import com.miaoparty.rest.api.service.response.TopicsResponse;

/**
 * @author Jason
 * 
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
	@Autowired
	TopicBiz topicBiz;

	@Override
	public TopicResponse getTopic(int topicId) {
		Topic topic = topicBiz.getTopic(topicId);
		TopicResponse response = new TopicResponse();
		response.setAuthor(topic.getAuthor());
		response.setCategoryId(topic.getCategoryId());
		response.setContent(topic.getContent());
		response.setDate(topic.getDate());
		response.setId(topic.getId());
		response.setReference(topic.getReference());
		response.setTitle(topic.getTitle());
		return response;
	}

	@Override
	public TopicsResponse getTopics() {
		// TODO Auto-generated method stub
		return null;
	}
}
