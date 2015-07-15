package com.miaoparty.rest.api.service;

import com.miaoparty.rest.api.service.dto.TopicResponse;
import com.miaoparty.rest.api.service.dto.TopicsResponse;

/**
 * @author Jason
 * 
 */
public interface TopicService {
	public TopicResponse getTopic(int topicId);

	public TopicsResponse getTopics();
}
