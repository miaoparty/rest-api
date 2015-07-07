package com.miaoparty.rest.api.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miaoparty.rest.api.biz.TopicBiz;
import com.miaoparty.rest.api.dao.TopicDAO;
import com.miaoparty.rest.api.entity.Topic;

@Component("topicBiz")
public class TopicBizImpl implements TopicBiz {
	@Autowired
	TopicDAO topicDAO;

	@Override
	public Topic getTopic(int topicId) {
		return topicDAO.getTopic(topicId);
	}

}
