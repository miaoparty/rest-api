package com.miaoparty.rest.api.dao.imp;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.miaoparty.rest.api.dao.TopicDAO;
import com.miaoparty.rest.api.entity.Topic;

@Component("topicDAO")
public class TopicDAOImpl implements TopicDAO {
	private HibernateTemplate hibernateTemplate;

	@Override
	public Topic getTopic(String topicId) {
		return (Topic) hibernateTemplate.findByNamedQueryAndNamedParam("getTopic", "topicId", topicId);
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
