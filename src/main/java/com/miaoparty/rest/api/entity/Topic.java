package com.miaoparty.rest.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TOPIC")
@NamedQueries({ @NamedQuery(name = "getTopic", query = "select t FROM TOPIC t where t.id = : topicId"), 
	            @NamedQuery(name = "getTopics", query = "select t FROM TOPIC t"),

})
public class Topic {
	@Id
	@Column(name = "ID")
	int id;

	@Column(name = "AUTHOR")
	String author;

	@Column(name = "REFERENCE")
	String reference;

	@Column(name = "DATE")
	Date date;

	@Column(name = "CATEGORY_ID")
	int categoryId;

	@Column(name = "TITLE")
	String title;

	@Column(name = "CONTENT")
	String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
