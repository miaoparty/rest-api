package com.miaoparty.rest.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.miaoparty.rest.api.dao.TopicDAO;
import com.miaoparty.rest.api.entity.Topic;

@Component("topicDAO")
public class TopicDAOImpl implements TopicDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Topic getTopic(int topicId) {
		@SuppressWarnings("unchecked")
		List<Topic> topics = (List<Topic>) hibernateTemplate.findByNamedQueryAndNamedParam("getTopic", "topicId", topicId);
		if (topics.size() > 0) {
			return topics.get(0);
		} else {
			return null;
		}
	}
}
