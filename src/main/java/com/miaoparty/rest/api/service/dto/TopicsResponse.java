package com.miaoparty.rest.api.service.dto;

import java.util.List;

public class TopicsResponse {
	int count;
	List<TopicResponse> topics;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<TopicResponse> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicResponse> topics) {
		this.topics = topics;
	}

}
