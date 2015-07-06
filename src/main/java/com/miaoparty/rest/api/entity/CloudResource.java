package com.miaoparty.rest.api.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class CloudResource {
	@Id
	@Column(name = "ID")
	int id;
	String name;
	String url;
	String fileExt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
}
