package com.miaoparty.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miaoparty.rest.api.service.TopicService;
import com.miaoparty.rest.api.service.dto.TopicResponse;
import com.miaoparty.rest.api.service.dto.TopicsResponse;

@RestController
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	TopicService service;

	@RequestMapping(value = "/{topicId}", method = RequestMethod.GET)
	public TopicResponse getTopic(@PathVariable("topicId") int topicId) {
		return service.getTopic(topicId);
	}

	@RequestMapping(value = "/getTopics", method = RequestMethod.GET)
	public TopicsResponse getTopics() {
		return null;
	}
}
