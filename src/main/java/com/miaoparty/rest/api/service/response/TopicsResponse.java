package com.miaoparty.rest.api.service.response;

import java.util.HashSet;
import java.util.Set;

public class TopicsResponse {
	String count;
	Set<TopicResponse> topics = new HashSet<TopicResponse>();

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Set<TopicResponse> getTopics() {
		return topics;
	}

	public void setTopics(Set<TopicResponse> topics) {
		this.topics = topics;
	}

}
